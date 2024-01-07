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

public class ArrayManipulationWithIntStream {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 5, 8, 10, 9, 2, 16, 8, 15, 4};

        IntStream range = IntStream.range(10, 21);
        System.out.println("range: " + Arrays.toString(range.toArray()));


// #############################################################################################
        int sum = IntStream.of(numbers).sum();
        int min = IntStream.of(numbers).min().getAsInt();
        OptionalInt max = IntStream.of(numbers).max();
        double average = IntStream.of(numbers).average().getAsDouble();

        IntStream sorted = IntStream.of(numbers).sorted();
        int[] sortedDistinctNumbers = IntStream.of(numbers).sorted().distinct().toArray();

        System.out.println("sum: " + sum);
        System.out.println("min: " + min);
        System.out.println("max: " + max.getAsInt());
        System.out.println("avg: " + average);
        System.out.println("sorted: " + Arrays.toString(sorted.toArray()));
        System.out.println("sorted unique num: " + Arrays.toString(sortedDistinctNumbers));
// #############################################################################################



// #############################################################################################
        long count = IntStream.of(numbers).count();
        IntStream distinct = IntStream.of(numbers).distinct();

        System.out.println("Count: " + count);
        System.out.println("Count: " + numbers.length);
        System.out.println("Unique: " + Arrays.toString(distinct.toArray()));
// #############################################################################################



// #############################################################################################
        OptionalInt findFirst = IntStream.of(numbers).findFirst();
        IntStream limit = IntStream.of(numbers).limit(5);
        IntStream skip = IntStream.of(numbers).skip(5);

        System.out.println("FindFirst: " + findFirst.getAsInt());
        System.out.println("takeFirst5: " + Arrays.toString(limit.toArray()));
        System.out.println("skipFirst5: " + Arrays.toString(skip.toArray()));
// #############################################################################################

        // it contains count, sum, min, average, max
        IntSummaryStatistics summaryStatistics = IntStream.of(numbers).summaryStatistics();
        System.out.println("summaryStatistics: " + summaryStatistics);
        System.out.println("summaryStatistics - count: " + summaryStatistics.getCount());
        System.out.println("summaryStatistics - Sum: " + summaryStatistics.getSum());
        System.out.println("summaryStatistics - Min: " + summaryStatistics.getMin());
        System.out.println("summaryStatistics - Max: " + summaryStatistics.getMax());
        System.out.println("summaryStatistics - Avg: " + summaryStatistics.getAverage());

// #############################################################################################



        DoubleStream doubleStream = IntStream.of(numbers).asDoubleStream();
        System.out.println("doubleStream: " + Arrays.toString(doubleStream.toArray()));


    }
}
