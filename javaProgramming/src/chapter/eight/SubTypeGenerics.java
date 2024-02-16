package chapter.eight;

import java.util.Arrays;

/**
 * Author: Muhammad Saimon
 * Since 2/17/24 12:52 AM
 */

public class SubTypeGenerics<T> {

    private static final int MAX_LENGTH = 5;
    private int currentIndex = 0;

    private T[] items;

    public SubTypeGenerics() {
        this.items = (T[]) new Object[MAX_LENGTH];
    }

    public void setItems(T item) {
        if (currentIndex < MAX_LENGTH) {
            items[currentIndex++] = item;
        } else {
            throw new IndexOutOfBoundsException("Array is full. Max 5");
        }
    }

    public T[] getItems() {
        return items;
    }

    public void printAll () {
        for (int i = 0; i < currentIndex; i++) {
            String sign = (currentIndex == (i + 1)) ? "" : ", ";
            System.out.print(items[i] + sign);
        }
    }

    public T getItem(int index) {
        if (index >= MAX_LENGTH) {
            throw new IllegalArgumentException("Index " + index + " is greater or equal to Max size 5");
        }
        return items[index];
    }



    public static void main(String[] args) {
        SubTypeGenerics<Integer> intArray = new SubTypeGenerics<>();
        intArray.setItems(5);
        intArray.setItems(10);
        intArray.setItems(15);
        intArray.setItems(20);
//        intArray.setItems(25);
//        intArray.setItems(30);

        System.out.println("All items: " + Arrays.toString(intArray.getItems()));

        System.out.println("Single item: " + intArray.getItem(4));
        intArray.printAll();

/*

        // Possible. Cause every class is a subclass of Object. here String is a subclass of Object and Object is a super class.
        String str = new String();
        str = "Hasan";
        Object obj = str;

        System.out.println("\n" + obj);

        // Not Possible. Cause String is a subclass of Object not a super class.
        Object obj2 = new Object();
        String str2 = obj2;

        // Not Possible. Despite String being a subclass of Object, in Generic this is not possible at all.
        SubTypeGenerics<String> strContainer = new SubTypeGenerics<>();
        SubTypeGenerics<Object> objContainer = strContainer;

*/


    }
}
