// --== CS400 File Header Information ==--
// Name: Jack Robey
// Email: jmrobey@wisc.edu
// Team: Team AA
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: None

package Test1;

import Backend2.Book;
import Backend2.State;

import DataWrangler1.DataUtils;

import Common.HashTableMap;
import Common.MapADT;

public class TestVirtualBookTracker {

  /**
   * This test method creates 2 state objects: one with imported data, another with no imported
   * data. Since both objects start with imported data, all imported data is removed from
   * noImportState (the state object with no imported data) and is replaced with non-imported data
   * via the add() method. The string output of the two state objects are then compared.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean testImportOfData() {
    // State object with imported data
    State importState = new State();
    // State object with non-imported data
    State noImportState = new State();
    // Removing the imported data
    noImportState.remove(9780316450867L);
    noImportState.remove(9780007158447L);
    noImportState.remove(9780385537858L);
    noImportState.remove(9780060173227L);
    noImportState.remove(9780192827807L);
    noImportState.remove(9780756948801L);
    noImportState.remove(9781416936473L);
    // Defining the non-imported data
    Book book1 = new Book(9780316450867L, "The Catcher in the Rye", "J. D. Salinger", 5);
    Book book2 = new Book(9780007158447L, "Cat in the Hat", "Dr. Suess", 2);
    Book book3 = new Book(9780385537858L, "Inferno", "Dante Alighieri", 5);
    Book book4 = new Book(9780060173227L, "To Kill a Mockingbird", "Harper Lee", 4);
    Book book5 = new Book(9780192827807L, "War and Peace", "Leo Tolstoy", 5);
    Book book6 = new Book(9780756948801L, "The Kite Runner", "Khaled Hosseini", 4);
    Book book7 = new Book(9781416936473L, "Hatchet", "Gary Paulsen", 4);
    // Adding the non-imported data
    noImportState.add(book1);
    noImportState.add(book2);
    noImportState.add(book3);
    noImportState.add(book4);
    noImportState.add(book5);
    noImportState.add(book6);
    noImportState.add(book7);
    if (!noImportState.toString().equals(importState.toString())) {
      return false;
    }
    return true;
  }

  /**
   * This test method creates a State object (initializing the hash table) and attempts to add 4
   * book objects, each with some type of erroneous input. Each instance of erroneous input should
   * trigger a response from the front end, thus checking if the front end error messages work as
   * expected.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean testBadBookInput() {
    State state = new State();
    // Input with an ISBN number that is not 10 or 13 digits
    Book book1 = new Book(978078683865301737L, "The Lightning Thief", "Rick Riordan");
    if (!state.add(book1) == false) {
      return false;
    }
    // Input with a rating less than 0
    Book book2 = new Book(9780451524935L, "1984", "George Orwell", -1);
    if (!state.add(book2) == false) {
      return false;
    }
    // Input with a null title and null author
    Book book3 = new Book(9758120731654L, null, null);
    if (!state.add(book3) == false) {
      return false;
    }
    return true;
  }

  /**
   * This test method tests whether the methods for modifying the information in a book object work
   * or not.
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean testBookDetails() {
    Book book1 = new Book(978078683865301737L, "The Lightning Thief", "Rick Riordan", 9);
    // Tests setAuthor() method
    book1.setAuthor("Jack Robey");
    if (!book1.getAuthor().equals("Jack Robey")) {
      return false;
    }
    // Tests setTitle() method
    book1.setTitle("Story");
    if (!book1.getTitle().equals("Story")) {
      return false;
    }
    // Tests setRating() method
    book1.setRating(10);
    if (book1.getRating() != 10) {
      return false;
    }
    return true;
  }

  /**
   * Tests whether book objects are correctly added to (or removed from) the hash table using the
   * add() and remove() methods
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean testAddRemove() {
    State state = new State();
    Book book1 = new Book(9780786838653L, "The Lightning Thief", "Rick Riordan");
    state.add(book1);
    if (!book1.toString().equals(state.get(9780786838653L).toString())) {
      return false;
    }
    Book book2 = new Book(9780451524935L, "1984", "George Orwell");
    state.add(book2);
    if (!book2.toString().equals(state.get(9780451524935L).toString())) {
      return false;
    }
    state.remove(9780451524935L);
    if (state.get(9780451524935L) != null) {
      return false;
    }
    return true;
  }

  /**
   * Tests to see if the hash table remains the same (empty) after the remove() method is called
   * 
   * @return true if the test passes and false if the test fails
   */
  public static boolean testRemoveEmptyHashTable() {
    State state = new State();
    String before = state.toString();
    state.remove(9780786838653L);
    String after = state.toString();
    if (!before.equals(after)) {
      return false;
    }
    return true;
  }

  /*
   * Executes the test methods and prints their results
   * 
   * @param args if any
   */
  public static void main(String[] args) {
    System.out.println(testImportOfData());
    System.out.println(testBadBookInput());
    System.out.println(testBookDetails());
    System.out.println(testAddRemove());
    System.out.println(testRemoveEmptyHashTable());
  }

}
