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
        Book book1 = new Book(923_1_23_872890_2L, "Apple Johnson", "Farmerville", 4);
        Book book2 = new Book(978_3_16_148410_0L, "Paul John", "Thanks and Planes", 3);
        State expected = new State();
        removeAllPreviousBooks(expected);
        expected.add(book1);
        expected.add(book2);
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

    // Utility method to get state with empty map
    private static void removeAllPreviousBooks(State expected) {
        
    }
}
