package chapter.eight;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

/**
 * Author: Muhammad Saimon
 * Since 2/17/24 7:33 PM
 */

public class StackUsingGenerics<T> {
    private static final int DEFAULT_CAPACITY = 3;

    private T[] elements;
    private int size;

    public StackUsingGenerics() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public String printElements() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");

        System.out.println("Data: " + Arrays.toString(elements));
        for (T element : elements) {
            stringJoiner.add(String.valueOf(element));
        }

        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        StackUsingGenerics<Integer> intStack = new StackUsingGenerics<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.push(40);
        intStack.push(50);
        intStack.push(60);

        System.out.println(intStack.isEmpty());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Final: " + intStack.printElements());



        StackUsingGenerics<String> cities = new StackUsingGenerics<>();
        cities.push("Makkah");
        cities.push("Madina");
        cities.push("Chittagong");
        cities.push("Dhaka");
        cities.push("Cox's Bazar");
        cities.push("Dubai");
        cities.push("Toronto");

        System.out.println("Size of Cities: " + cities.size);
        System.out.println("Pop: " + cities.pop());
        System.out.println("All Cities: " + cities.printElements());



    }
}
