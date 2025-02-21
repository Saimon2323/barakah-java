package map;

import java.util.Hashtable;
import java.util.Map;

/**
 * @Author Muhammad Saimon
 * @since Feb 22, 2025 2:57 AM
 */

public class MainHashTable {
    public static void main(String[] args) {
        Map<String, Integer> bookshelf = new Hashtable<>(3);
        // Initial capacity of 3. Default is 16. Initial capacity 3 means what? need to search.
        // Load factor is 0.75.
        ////// Load factor is the threshold after which the capacity of the map is doubled. It is a fraction of the map size. The default load factor is 0.75, which means the map will be resized when 75% of the map is filled. The load factor must be between 0 and 1. The initial capacity is the number of buckets in the hash table. The default initial capacity is 16. The capacity of the map is doubled when the load factor is reached.

        // Add some books to the shelf
        bookshelf.put("Moby Dick", 1);
        bookshelf.put("War and Peace", 2);
        bookshelf.put("The Great Gatsby", 3);
        bookshelf.put("1984", 4);
        bookshelf.put("The Great Gatsby", 5);

        // Search for a specific book
        String targetBook = "The Great Gatsby";
        if (bookshelf.containsKey(targetBook)) {
            System.out.println("Book found at slot: " + bookshelf.get(targetBook));
        } else {
            System.out.println("Book not found.");
        }
    }
}
