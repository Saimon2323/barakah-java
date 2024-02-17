package chapter.eight;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Author: Muhammad Saimon
 * Since 2/17/24 3:28 PM
 */

public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 3;

    private T[] elements;
    private int size;

    public DynamicArray() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addItem(T item) {
        System.out.println("Size: " + size);
        System.out.println("element size: " + elements.length);
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public T getItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        System.out.println("Data: " + Arrays.toString(elements));
        for (T element : elements) {
            stringJoiner.add(String.valueOf(element));
        }

        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        DynamicArray<Integer> intArray = new DynamicArray<>();
        intArray.addItem(10);
        intArray.addItem(20);
        intArray.addItem(30);
        intArray.addItem(40);
        intArray.addItem(50);
//        intArray.addItem(60);

        System.out.println(intArray.isEmpty());
        System.out.println(intArray.getItem(3));
        System.out.println("Final: " + intArray);



        DynamicArray<String> cities = new DynamicArray<>();
        cities.addItem("Makkah");
        cities.addItem("Madina");
        cities.addItem("Chittagong");
        cities.addItem("Dhaka");
        cities.addItem("Cox's Bazar");
        cities.addItem("Dubai");
        cities.addItem("Toronto");

        System.out.println("Size of Cities: " + cities.size);
        System.out.println("All Cities: " + cities);



    }
}
