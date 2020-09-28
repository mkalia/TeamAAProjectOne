package Test2;

import Backend2.Book;
import Common.HashTableMap;
import Common.MapADT;

/**
 * Key Tests: Successful import of txt data into app (printed list matches
 * expected data) Add lots of books to check performance issues Add/remove books
 * and check if the printed list matches Change details of books and check if
 * the printed list matches those changes
 */
public class TestVirtualBookTracker {
    // Add book with incorrect data (to trigger the front end error messages)
    public static boolean addBookWithBadISBN() {
        MapADT<Long,Book> map = new HashTableMap<>();
        long isbn = 123L;
        boolean hasPut = map.put(isbn, new Book(isbn, "Apple Johnson", "Farmerville", 2));
        return !hasPut;
    }

    // Add book with incorrect data (to trigger the front end error messages)
    public static boolean addBookWithBadRating() {
        MapADT<Long,Book> map = new HashTableMap<>();
        long isbn = 978_3_16_148410_0L;
        boolean hasPut = map.put(isbn, new Book(isbn, "Paul John", "Thanks and Planes", -1));
        return !hasPut;
    }

    // Remove book with empty hash table
    public static boolean removeFromEmptyMap() {
        MapADT<Long,Book> map = new HashTableMap<>();
        // String prev = getAllBooks(map);
        Book nothing = map.remove(12345L);
        // String post = getAllBooks(map);
        return nothing == null;// && prev.equals(post);
    }
}

