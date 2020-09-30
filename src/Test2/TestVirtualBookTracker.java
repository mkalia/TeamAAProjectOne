package Test2;

import Backend2.Book;
import Backend2.State;

/**
 * All of these tests return true if they are successful
 */
public class TestVirtualBookTracker {
    // Successful import of txt data into app (printed list matches expected data)
    public static boolean importSuccessful() {
        State actual = new State();
        State expected = new State();
        removeAllPreviousBooks(expected);
        addAllPreviousBooks(expected);
        return actual.toString().equals(expected.toString());
    }

    // Add book with incorrect data (to trigger the front end error messages)
    public static boolean addBookWithBadISBN() {
        State state = new State();
        Book book = new Book(123L, "Apple Johnson", "Farmerville", 2);
        boolean hasPut = state.add(book);
        return !hasPut;
    }

    // Add book with incorrect data (to trigger the front end error messages)
    public static boolean addBookWithBadRating() {
        State state = new State();
        Book book = new Book(978_3_16_148410_0L, "Paul John", "Thanks and Planes", -1);
        boolean hasPut = state.add(book);
        return !hasPut;
    }

    // Remove book from empty hash table
    public static boolean removeFromEmptyMap() {
        State state = new State();
        removeAllPreviousBooks(state);
        String prev = state.toString();
        Book nothing = state.remove(12345L);
        String post = state.toString();
        return nothing == null && prev.equals(post);
    }

    // Add/remove books and check if the printed list matches
    public static boolean addRemoveAndCheck() {
        State state = new State();
        Book book = new Book(123_4_56_789101_1L, "Rooster", "Lighthouse", 3);
        state.add(book);
        // TODO: Replace with actual isbn
        state.remove(98765L);
        String expected = "";
        return state.toString().equals(expected);
    }

    // Change details of books and check if the printed list matches those changes
    public static boolean changeAndCheck() {
        State state = new State();
        // TODO: Replace with actual isbn
        Book book = state.remove(98765L);
        book.setRating(1);
        state.add(book);
        String expected = "";
        return state.toString().equals(expected);
    }

    public static void main(String[] args) {
        System.out.println(importSuccessful());
        System.out.println(addBookWithBadISBN());
        System.out.println(addBookWithBadRating());
        System.out.println(removeFromEmptyMap());
        System.out.println(addRemoveAndCheck());
        System.out.println(changeAndCheck());
    }

    // From our shared library.txt
    private static long[] previousISBNs = { 9781416936473L, 9780756948801L, 9780192827807L, 9780060173227L,
            9780385537858L, 9780007158447L, 9780316450867L };

    // Utility method to get state with empty map
    private static void removeAllPreviousBooks(State state) {
        for (long isbn : previousISBNs)
            state.remove(isbn);
    }

    // Utility method to add books that are expected from library.txt
    private static void addAllPreviousBooks(State expected) {
        expected.add(new Book(9781416936473L, "Hatchet", "Gary Paulsen", 4));
        expected.add(new Book(9780756948801L, "The Kite Runner", "Khaled Hosseini", 4));
        expected.add(new Book(9780192827807L, "War and Peace", "Leo Tolstoy", 5));
        expected.add(new Book(9780060173227L, "To Kill a Mockingbird", "Harper Lee", 4));
        expected.add(new Book(9780385537858L, "Inferno", "Dante Alighieri", 5));
        expected.add(new Book(9780007158447L, "Cat in the Hat", "Dr. Suess", 2));
        expected.add(new Book(9780316450867L, "The Catcher in the Rye", "J. D. Salinger", 5));
    }
}
