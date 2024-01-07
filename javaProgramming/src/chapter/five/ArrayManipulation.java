package chapter.five;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @Author Muhammad Saimon
 * @since Aug 8/19/20 8:37 PM
 */

public class ArrayManipulation {
    public static void main(String[] args) {
        int[] numArray = {2, 3, 3, 5, 8, 10, 9, 2, 16, 8, 15, 6};

// #############################################################################################
        int sum = Arrays.stream(numArray).sum();
        int min = Arrays.stream(numArray).min().getAsInt();
        OptionalInt max = Arrays.stream(numArray).max();
        double average = Arrays.stream(numArray).average().getAsDouble();

        IntStream sorted = Arrays.stream(numArray).sorted();
        int[] sortedDistinctNumbers = Arrays.stream(numArray).sorted().distinct().toArray();

        System.out.println("sum= " + sum);
        System.out.println("min= " + min);
        System.out.println("max= " + max.getAsInt());
        System.out.println("avg= " + average);
        System.out.println("sorted= " + Arrays.toString(sorted.toArray()));
        System.out.println("sorted unique num= " + Arrays.toString(sortedDistinctNumbers));
// #############################################################################################



// #############################################################################################
        long count = Arrays.stream(numArray).count();
        IntStream distinct = Arrays.stream(numArray).distinct();

        System.out.println("Count= " + count);
        System.out.println("Count= " + numArray.length);
        System.out.println("Unique= " + Arrays.toString(distinct.toArray()));
// #############################################################################################



// #############################################################################################
        OptionalInt findFirst = Arrays.stream(numArray).findFirst();
        IntStream limit = Arrays.stream(numArray).limit(5);
        IntStream skip = Arrays.stream(numArray).skip(5);

        System.out.println("FindFirst= " + findFirst.getAsInt());
        System.out.println("takeFirst5= " + Arrays.toString(limit.toArray()));
        System.out.println("skipFirst5= " + Arrays.toString(skip.toArray()));
// #############################################################################################

        // it contains count, sum, min, average, max
        IntSummaryStatistics summaryStatistics = Arrays.stream(numArray).summaryStatistics();
        System.out.println("summaryStatistics= " + summaryStatistics);
        System.out.println("summaryStatistics - count= " + summaryStatistics.getCount());
        System.out.println("summaryStatistics - Sum= " + summaryStatistics.getSum());
        System.out.println("summaryStatistics - Min= " + summaryStatistics.getMin());
        System.out.println("summaryStatistics - Max= " + summaryStatistics.getMax());
        System.out.println("summaryStatistics - Avg= " + summaryStatistics.getAverage());

// #############################################################################################

        DoubleStream doubleStream = Arrays.stream(numArray).asDoubleStream();
        System.out.println("doubleStream: " + Arrays.toString(doubleStream.toArray()));

// #############################################################################################

        Arrays.sort(numArray);
        //Arrays.parallelSort(numArray);
        int searchResult = Arrays.binarySearch(numArray, 9);
        System.out.println("Position of 9: " + searchResult);



    }
}
