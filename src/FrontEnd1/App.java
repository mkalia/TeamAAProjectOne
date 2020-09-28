//Grant Parfrey
package FrontEnd1;
/*
import Backend2.Book;
import Backend2.State;
import Data1.DataUtils;
*/

import Common.HashTableMap;
import Common.MapADT;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        App current = new App();
        //State state  =new State();
        System.out.println("Welcome to the Online Book Catalog!");
        System.out.println("This program stores ISBN's, book titles, authors, and ratings.");
        System.out.println("To interact, simply enter the number (integer only) that corresponds to the menu item you want.");
        current.writeMenu();
        int i = 0;
        while (i != 6) {
            if (!input.hasNextInt()) {
                i = -2;
                input.nextLine();
            } else {
                i = input.nextInt();
            }
            switch (i) {
                case 1: //add a new book
                    System.out.println("Case 1");
                    break;
                case 2://lookup
                    System.out.println("Case 2");
                    break;
                case 3://remove
                    System.out.println("What is the ISBN of the book to remove?");
                    //state.remove();
                    break;
                case 4://prints all books
                    //TODO
                    break;
                case 5://save changes
                    //state.save();
                    break;
                case 6://quits the application

                    break;
                case 7:
                    current.writeMenu();
                    break;
                default:
                    System.out.println("Please enter a integer in the range provided. Enter 6 to list the menu.");
                    break;
            }
        }
    }
    private void writeMenu(){
        System.out.println("1: Add new book");
        System.out.println("2: Lookup a book from a ISBN");
        System.out.println("3: Remove a book");
        System.out.println("4: Print all the book data");
        System.out.println("5: Save local changes to .txt file");
        System.out.println("6: Quit the application WITHOUT saving changes");
        System.out.println("7: List menu again");
    }
/*
add:
state.add(book.isbn,book);
save:
state.save();

 */
}

