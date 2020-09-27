package ProjectOne;

/**
 * Key Tests:
Successful import of txt data into app (printed list matches expected data)
Add lots of books to check performance issues
Add/remove books and check if the printed list matches
Change details of books and check if the printed list matches those changes
*/
public class TestVirtualBookTracker {
    // Add book with incorrect data (to trigger the front end error messages)
    public static boolean addBookWithBadISBN() {
        HashTableMap<Long,Book> map = new HashTableMap<>();
        boolean hasPut = map.put((long) 123, new Book("Apple Johnson", "Farmerville", 2.3));
        return !hasPut;
    }

    // Add book with incorrect data (to trigger the front end error messages)
    public static boolean addBookWithBadRating() {
        HashTableMap<Long,Book> map = new HashTableMap<>();
        boolean hasPut = map.put(978_3_16_148410_0L, new Book("Paul John", "Thanks and Planes", -1));
        return !hasPut;
    }

    // Remove book with empty hash table
    public static boolean removeFromEmptyMap() {
        HashTableMap<Long,Book> map = new HashTableMap<>();
        // String prev = getAllBooks(map);
        Book nothing = map.remove((long) 12345);
        // String post = getAllBooks(map);
        return nothing == null;// && prev.equals(post);
    }
}

