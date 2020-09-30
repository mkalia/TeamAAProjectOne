// --== CS400 File Header Information ==--
// Name: Alexander Ulate
// Email: ulate@wisc.edu
// Team: AA
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader:
package FrontEnd2;
import Common.HashTableMap; // add the HashTableMap
import Common.MapADT; // Add the Map abstract data type
import java.util.Scanner; // Get the scanner for the interface
import Backend2.Book;
import Backend2.State;

/**
 * This class implements the interface for a book tracking app. The user can interact with the app
 * by pressing commands in the command window.
 * 
 * @author Alexander Ulate
 *
 */
public class App {
  private static String tempTitle; // A temporary storage for the title
  private static Long tempIsbn; // Temporary storage for ISBN #
  private static String tempAuthor; // Temporary storage for Author
  private static int tempRating; // Temporary storage for rating
  
  public App() {
    tempTitle = null; // A temporary storage for the title
    tempIsbn = null; // Temporary storage for ISBN #
    tempAuthor = null; // Temporary storage for Author
    tempRating = 0; // Temporary storage for rating
  }
  /**
   * This private method prints out a line of a given character at a given length
   * 
   * @param symb   - The symbol of the line
   * @param length - The length of the line
   */
  private static void printLine(char symb, int length) {
    for (int i = 0; i < length; i++) {
      System.out.print(symb); // Print out the symbol into a line
    }
    System.out.println(); // Set the next line
  }

  /**
   * This method prints out the menu for the app
   */
  private static void printStartUp() {
    printLine('/', 45);
    System.out.println("//     WELCOME TO THE BOOK TRACKER APP     //");
    printLine('/', 45);
    empty();
    printLine('/', 45);
    System.out.println("// This app allows you to track the books  //");
    System.out.println("// you have read and give them a rating.   //");
    System.out.println("// As long as you have the book title,     //");
    System.out.println("// author, and ISBN number, you can keep   //");
    System.out.println("// track of it here! For more information  //");
    System.out.println("// please see the help section.            //");
    printLine('/', 45);
    empty();
  }

  /**
   * This method prints out an error message for an invalid input
   * 
   * @param error - The error message that needs to be printed
   */
  private static void error(String error) {
    switch (error) {
      case "ISBN": // Invalid ISBN number
        System.out
            .println("INVALID INPUT. Please insert valid ISBN number of 13 decimal numbers");
        break;
      case "menu": // Invalid menu select
        System.out
          .println("INVALID INPUT. Please insert valid menu select \ncharacter ('m' to see menu again)");
        break;
      case "title":
        System.out
        .println("INVALID INPUT. Please insert valid title.");
        break;
      default:
        System.out.println("UNKNOWN INPUT ERROR");
    }
  }
  
  
  private static String addTitle(Scanner scnr) {
    boolean next = false; // Checking if if you should move on to next step
    String title = null;
    scnr.nextLine(); // accounts for the scanner error
    while(!next) {
      System.out.print("Title of book: ");
      title = scnr.nextLine();
      if(title == null || title.equals("")) { // Check that the title is not empty
        error("title");
        empty();
      }
      else {
        next = true; // Stop the loop, valid title
      }
    }
    return title;
  }
  
  private static Long addIsbn(Scanner scnr) {
    boolean next = false; // Checking if if you should move on to next step
    Long isbn = null;
    //scnr.nextLine(); // accounts for the scanner error
    while(!next) {
      System.out.print("ISBN Number: ");
      try { // Make sure the value entered is a long
        isbn = scnr.nextLong();
        String test = isbn.toString();
        if(test.length() == 10 || test.length() == 13)
          next = true;
        else {
          System.out.println("INVALID INPUT: Length of ISBN was not 10 nor 13");
          empty();
          scnr.nextLine();
        }
      } catch (Exception e) {
        error("isbn");
        empty();
        scnr.nextLine();
      }
    }
    return isbn;
  }
  
  /**
   * This method adds an Author to the book
   * @param scnr
   * @return author
   */
  private static String addAuthor(Scanner scnr) {
    boolean next = false; // Checking if if you should move on to next step
    String author = null;
    scnr.nextLine(); // accounts for the scanner error from Long
    while(!next) {
      System.out.print("Author of book: ");
      author = scnr.nextLine();
      if(author == null || author.equals("")) { // Check that the author is not empty
        error("author");
        empty();
      }
      else {
        next = true; // Stop the loop, valid author
      }
    }
    return author;
  }
  
  /**
   * This method adds a rating to a book
   * @param scnr - The user input
   * @return The rating
   */
  private static int addRating(Scanner scnr) {
    boolean next = false; // Checking if if you should move on to next step
    int rate = 0;
    while(!next) {
      System.out.print("Add a rating (0 - 5): ");
      try { // Make sure the value entered is a long
        rate = scnr.nextInt();
        if(rate <= 5 && rate >= 0)
          next = true;
        else {
          System.out.println("INVALID INPUT: Rating was not a number between 0 and 5");
          empty();
          scnr.nextLine();
        }
      } catch (Exception e) {
        error("rate");
        empty();
        scnr.nextLine();
      }
    }
    return rate;
  }

  /**
   * This method prints out an empty line
   */
  private static void empty() {
    System.out.println();
  }

  /**
   * This method prints out the menu for the commands the user can input
   */
  private static void printMenu() {
    empty();
    printLine('-', 22);
    System.out.println("|        MENU        |");
    printLine('-', 22);
    System.out.println("| Type letter to     |\n| select function    |");
    printLine('-', 22);
    System.out.println("* Add book: a        *");
    System.out.println("* Find book: f       *");
    System.out.println("* Remove book: r     *");
    System.out.println("* List books: l      *");
    System.out.println("* Save Tracker: s    *");
    System.out.println("* Quit w/o save: q   *");
    System.out.println("* Print Menu: m      *");
  }
  
  /**
   * This method runs the Add book functionality of the app.
   * 
   * @param scnr - the scanner
   */
  private static void addBook(Scanner scnr, State state) { 
    empty();
    printLine('*',22);
    System.out.println("*     ADD A BOOK     *");
    printLine('*',22);
    empty();
    
    // Get the title of the book
    tempTitle = addTitle(scnr);
    printLine('-',15);
    tempIsbn = addIsbn(scnr);
    printLine('-',15);
    tempAuthor = addAuthor(scnr);
    printLine('-',15);
    tempRating = addRating(scnr);
    printLine('-',15);
    
    // Create the book
    Book book = new Book(tempIsbn, tempTitle, tempAuthor, tempRating);
    
    // Make sure the book is added correctly
    if(state.add(book)) {
      System.out.println("Book was successfully added to the tracker! ");
      System.out.println(book.toString());
    } else {
      System.out.println("Book could not be added to tracker.");
      System.out.println("Book may already be part of tracker.");
      System.out.println("Check that book parameters were entered correctly.");
    }
  }
  
  /**
   * This method finds a book in the tracker from an ISBN number
   * 
   * @param scnr - The user input
   * @param state - The state of the tracker
   */
  private static void findBook(Scanner scnr, State state) {
    empty();
    printLine('*',22);
    System.out.println("*    FIND A BOOK     *");
    printLine('*',22);
    empty();
    
    System.out.println("Enter the ISBN Number of the book you are looking for: ");
    printLine('-',15);
    boolean next = false;
    Long isbn = null;
    while(!next) { // Get the ISBN number
      System.out.print("ISBN Number: ");
      try { // Make sure the value entered is a long
        isbn = scnr.nextLong();
        String test = isbn.toString();
        if(test.length() == 10 || test.length() == 13)
          next = true;
        else {
          System.out.println("INVALID INPUT: Length of ISBN was not 10 nor 13");
          empty();
          scnr.nextLine();
        }
      } catch (Exception e) {
        error("isbn");
        empty();
        scnr.nextLine();
      }
    }
    // Get the book with the given ISBN number
    Book lookUp = state.get(isbn);
    // Check if the book exists
    if (lookUp == null) {
      System.out.println("ISBN:" + isbn + " does not exist in tracker");
    } else {
      System.out.println("Book Found: ");
      System.out.println(lookUp.toString());
    }
  }
  
  /**
   * This method removes the book in the tracker 
   * 
   * @param scnr - The scanner to read input
   * @param state - the state of the tracker
   */
  private static void removeBook(Scanner scnr, State state) {
    empty();
    printLine('*',22);
    System.out.println("*   REMOVE A BOOK    *");
    printLine('*',22);
    empty();
    Long isbn = null;
    boolean next = false;
    System.out.println("Enter the ISBN Number of the book you want to remove: ");
    printLine('-',15);
    while(!next) { // Get the ISBN number
      System.out.print("ISBN Number: ");
      try { // Make sure the value entered is a long
        isbn = scnr.nextLong();
        String test = isbn.toString();
        if(test.length() == 10 || test.length() == 13)
          next = true;
        else {
          System.out.println("INVALID INPUT: Length of ISBN was not 10 nor 13");
          empty();
          scnr.nextLine();
        }
      } catch (Exception e) {
        error("isbn");
        empty();
        scnr.nextLine();
      }
    }
    
    Book removed = state.remove(isbn);
    if(removed == null) { // the book does not exist
      System.out.println("Book does not exist in tracker.");
    }else{
      System.out.println("Book removed: ");
      System.out.println(removed.toString());//prints the book that was removed
    }
  }
  
  /**
   * This method list out the books in the Tracker
   * 
   * @param state - The state of the Tracker
   */
  private static void listBooks(State state) {
    empty();
    printLine('*',22);
    System.out.println("*    LIST BOOKS      *");
    printLine('*',22);
    empty();
    
    System.out.println(state.toString()); // Prints out the books
  }
  

  /**
   * This is the main code, where the interface is run.
   * 
   * @param args
   */
  public static void main(String[] args) {
    printStartUp();
    printMenu();
    State state = new State();
    
    Scanner scnr = new Scanner(System.in); // create the scanner
    String input = null; // Create the input
    boolean end = false; // Helps keep text printing correctly
    
    printLine('-', 22);
    System.out.print("Enter menu function: ");
    
    // begin the app loop, which also contains the main menu loop
    do {
      input = scnr.next();
      
      switch (input) {
        case "a": // add a book
          addBook(scnr, state);
          break;
        case "q": // quit
          end = true;
          break;
        case "m": // print the menu
          printMenu();
          break;
        case "f": // find a book
          findBook(scnr, state);
          break;
        case "r": // remove book
          removeBook(scnr, state);
          break;
        case "l": // List the books
          listBooks(state);
          break;
        case "s": // Save the state of the tracker
          state.save();
          System.out.println("Save Successful!");
          break;
        default: // invalid input
          error("menu");
          break;
      }
      if (!end)
        printLine('-', 22);
        System.out.print("Enter menu function (m for menu): ");
    } while (!input.equals("q")); // When q, quit the program
    
    // End the program
    empty();
    printLine('-', 61);
    System.out.println("| CLOSING PROGRAM. Thank you for using the Book Tracker App |");
    printLine('-', 61);
    scnr.close(); // Close the scanner

  }

}
