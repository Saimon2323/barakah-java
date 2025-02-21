package map;

import java.util.Arrays;
import java.util.LinkedList;

// Custom HashTable implementation using LinkedList. This is a simple implementation to understand the concept of HashTable.
// This implementation is not thread-safe and does not handle collisions.
public class HashTable {

    private final LinkedList<Entry>[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(String key, int value) {
        int hash = hashFunction(key);
        LinkedList<Entry> entries = table[hash];
        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                entry.value = value;
                printTable();
                return;
            }
        }
        entries.add(new Entry(key, value));
        printTable();
    }

    private int hashFunction(Object key) {
        System.out.println("Key hashCode: " + key.hashCode());
        int hash = Math.abs(key.hashCode() % size);
        System.out.println("Hashed key: " + key + " to slot: " + hash);
        return hash;
    }

    public Integer get(String key) {
        int hash = hashFunction(key);
        LinkedList<Entry> entries = table[hash];
        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // key not found
    }

    private void printTable() {
        System.out.println(Arrays.toString(table));
        System.out.println();
    }

    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashTable bookshelf = new HashTable(10);

        // Add some books to the shelf
        bookshelf.put("Moby Dick", 1);
        bookshelf.put("War and Peace", 2);
        bookshelf.put("The Great Gatsby", 3);
        bookshelf.put("1984", 4);
        bookshelf.put("The Great Gatsby", 7);
        bookshelf.put("Pragmatic Programmer", 7);

        // Search for a specific book
        String targetBook = "The Great Gatsby";
        Integer slot = bookshelf.get(targetBook);
        if (slot != null) {
            System.out.println("Book found at slot: " + slot);
        } else {
            System.out.println("Book not found.");
        }
    }
}


