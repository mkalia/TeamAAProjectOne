// --== CS400 File Header Information ==--
// Name: Alexander Ulate
// Email: ulate@wisc.edu
// Team: AA
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader: 
//import Common.HashTableMap; // add the HashTableMap
//import Common.MapADT; // Add the Map abstract data type
import java.util.Scanner; // Get the scanner for the interface
/**
 * This class implements the interface for a book tracking app. The user can
 * interact with the app by pressing commands in the command window.
 * 
 * @author Alexander Ulate
 *
 */
public class App {
  
  /**
   * This private method prints out a line of a given character at a given length
   * 
   * @param symb - The symbol of the line
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
    printLine('/',45);
    System.out.println("//     WELCOME TO THE BOOK TRACKER APP     //");
    printLine('/',45);
    System.out.println();
    printLine('/',45);
    System.out.println("// This app allows you to track the books  //");
    System.out.println("// you have read and give them a rating.   //");
    System.out.println("// As long as you have the book title,     //");
    System.out.println("// author, and ISBN number, you can keep   //");
    System.out.println("// track of it here! For more information  //");
    System.out.println("// please see the help section.            //");
    printLine('/',45);
  }

  /**
   * This is the main code, where the interface is run.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    printStartUp();

  }

}
