// --== CS400 File Header Information ==--
// Name: Alexander Ulate
// Email: ulate@wisc.edu
// Team: AA
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader:
// import Common.HashTableMap; // add the HashTableMap
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
   * @param error - The number that the error corresponds to
   */
  private static void error(int error) {
    switch (error) {
      case 1: // Invalid ISBN number
        System.out
            .println("Invalid Input. Please insert valid ISBN number of 13 decimal numbers: ");
        break;
      case 2: // Invalid character
        System.out
          .println("Invalid Input. Please insert valid menu select character ('m' to see menu again): ");
        break;
      default:
        System.out.println("UNKNOWN INPUT ERROR");
    }
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
    System.out.println("*        MENU        *");
    printLine('-', 22);
    System.out.println("* Type letter to     *\n* select function    *");
    printLine('-', 22);
    System.out.println("* Add book: a        *");
    System.out.println("* Find book: f       *");
    System.out.println("* Remove book: r     *");
    System.out.println("* List books: l      *");
    System.out.println("* Save Tracker: s    *");
    System.out.println("* Quit w/o save: q   *");
    System.out.println("* Print Menu: m      *");
    printLine('-', 22);
    System.out.println("Enter function: ");
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
    
    // begin the app loop, which also contains the main menu loop
    do {
      input = scnr.next();
      
      switch (input) {
        case "a":
          break;
      }
      
    } while (!scnr.equals("q")); // When q, quit the program
    
    scnr.close(); // Close the scanner

  }

}
