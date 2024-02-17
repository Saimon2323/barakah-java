package chapter.eight;

import java.util.Arrays;

/**
 * Author: Muhammad Saimon
 * Since Feb 17, 2024 1:52 AM
 */

// <T extends Number> means T hote hobe oisob class jara Number er subclass
public class BoundedTypesInGenerics<T extends Number> {
    private T[] nums;

    public BoundedTypesInGenerics(T[] nums) {
        this.nums = nums;
    }

    // Return type Double in All Class
    public double average() {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue();
        }

        return sum / nums.length;
    }

    public static void main(String[] args) {

        Double[] dbl = {10.5, 20.5, 30.5};
        Integer[] integers = {10, 20, 30};

        BoundedTypesInGenerics<Double> doubleArray = new BoundedTypesInGenerics<>(dbl);
        double average = doubleArray.average();
        System.out.println(average);

        BoundedTypesInGenerics<Integer> intArray = new BoundedTypesInGenerics<>(integers);
        System.out.println(intArray.average());

        String[] str = {"A", "B"};

        // Not Possible. Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
        // BoundedTypesInGenerics<String> strArray = new BoundedTypesInGenerics<>(str);
    }

}
