// --== CS400 File Header Information ==--
// Name: Alexander Ulate
// Email: ulate@wisc.edu
// Team: AA
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader:
//import Common.HashTableMap; // add the HashTableMap
// import Common.MapADT; // Add the Map abstract data type
import java.util.Scanner; // Get the scanner for the interface

/**
 * This class implements the interface for a book tracking app. The user can interact with the app
 * by pressing commands in the command window.
 * 
 * @author Alexander Ulate
 *
 */
public class App {

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
      default:
        System.out.println("UNKNOWN INPUT ERROR");
    }
  }
  
  /**
   * This method checks that the input is valid. The check it does depends on
   * the check passes into it as a character.
   *    Title   :   t
   *    ISBN    :   i
   *    Rating  :   r
   *    Author  :   a
   *    
   * @param input - The input from the user
   * @param check - The type of input you are checking
   * @return Weather it is valid or not
   */
  private static boolean checkInput(String input, char check) {
    switch (check) {
      case 't':
        break;
      default:
        break;
    }
    return false; // Not valid
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
  private static void addBook(Scanner scnr) {
    String title; // The title
    String isbn; // the ISBN number
    int rating; // The book rating
    
    empty();
    printLine('*',22);
    System.out.println("*     ADD A BOOK     *");
    printLine('*',22);
    empty();
    
    System.out.print("Title of book: ");
    
    
  }

  /**
   * This is the main code, where the interface is run.
   * 
   * @param args
   */
  public static void main(String[] args) {
    printStartUp();
    printMenu();
    
    Scanner scnr = new Scanner(System.in); // create the scanner
    String input = null; // Create the input
    boolean end = false; // Helps keep text printing correctly
    
    printLine('-', 22);
    System.out.print("Enter function: ");
    
    // begin the app loop, which also contains the main menu loop
    do {
      input = scnr.next();
      
      switch (input) {
        case "a":
          addBook(scnr);
          break;
        case "q":
          end = true;
          break;
        case "m":
          printMenu();
          break;
        default:
          error("menu");
          break;
      }
      if (!end)
        printLine('-', 22);
        System.out.print("Enter function: ");
    } while (!input.equals("q")); // When q, quit the program
    
    // End the program
    empty();
    printLine('-', 61);
    System.out.println("| CLOSING PROGRAM. Thank you for using the Book Tracker App |");
    printLine('-', 61);
    scnr.close(); // Close the scanner

  }

}
