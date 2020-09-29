//Grant Parfrey
package FrontEnd1;
import Backend2.*;
import Common.*;
import java.util.Scanner;
import Backend2.Book;
import Backend2.State;
import Common.HashTableMap;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        App current = new App();
        State state = new State();
        System.out.println("Welcome to the Online Book Catalog!");
        System.out.println("This program stores ISBN's, book titles, authors, and ratings.");
        System.out.println("To interact, simply enter the number (integer only) that corresponds to the menu item you want.");

        int i = -999;
        while (i != 6) {
            if(i==-999){//see if this is the first time that the program is run
                current.writeMenu();
            }else{//if this is not the first time it is run, that means the user just got back to the menu
                System.out.println("You are now back to the menu. Enter your desired task. Enter 7 to see menu options.");
            }
            if (!input.hasNextInt()) {
                i = -2;
                input.nextLine();
            } else {
                i = input.nextInt();
            }
            switch (i) {
                case 1: //add a new book
                    System.out.println("Adding a new book!");
                    System.out.println("Please enter the ISBN, making sure it is 10 or 13 digits long.");
                    if(!input.hasNextLong()) {
                        input.nextLine();
                        System.out.println("A long value type was not found. Please try adding a new book again.");
                        break;
                    }
                    Long tempISBN = input.nextLong();
                    String stringISBN = tempISBN.toString();
                    if(stringISBN.length() != 10 && stringISBN.length() != 13){
                        System.out.println("The length you entered was: "+stringISBN.length());
                        System.out.println("Please try adding a book again with the correct length of 10 or 13");
                        break;
                    }
                    System.out.println("Please enter the title in the form of a string.");
                    input.nextLine();//buffer due to adding a long above
                    if(!input.hasNextLine()) {
                        input.nextLine();
                        System.out.println("A String value type was not found. Please try adding a new book again.");
                        break;
                    }
                    String tempTitle = input.nextLine();
                    System.out.println("Please enter the Author in the form of a string.");
                    if(!input.hasNextLine()) {
                        input.nextLine();
                        System.out.println("A String value type was not found. Please try adding a new book again.");
                        break;
                    }
                    String tempAuthor = input.nextLine();
                    System.out.println("Please enter the rating in the form of an integer. Must be zero or greater.");
                    if(!input.hasNextInt()) {
                        input.nextLine();
                        System.out.println("A integer value type was not found. Please try adding a new book again.");
                        break;
                    }
                    int tempRating = input.nextInt();
                    if(tempRating < 0){
                        System.out.println("This is not a valid rating. Please adding a book again.");
                        break;
                    }
                    Book tempBook = new Book(tempISBN, tempTitle, tempAuthor, tempRating);
                    if(state.add(tempBook)){
                        System.out.println("Congratulations, the following book has been added:");
                        System.out.println(tempBook.toString());
                    }else{
                        System.out.println("Something went wrong.");
                        System.out.println("Common errors:");
                        System.out.println("ISBN is not 10 or 13 digits");
                        System.out.println("The book rating is below 0");
                    }
                    break;
                case 2://lookup
                    System.out.println("Please enter the ISBN of the book you are trying to find.");
                    if(!input.hasNextLong()) {
                        input.nextLine();
                        System.out.println("A long value type was not found.");
                        break;
                    }
                    Long lookupISBN = input.nextLong();
                    if(lookupISBN.toString().length() != 10 && lookupISBN.toString().length() != 13){
                        System.out.println("The length you entered was: "+lookupISBN.toString().length());
                        System.out.println("Please try adding a book again with the correct length of 10 or 13");
                        break;
                    }
                    Book lookupBook = state.get(lookupISBN);
                    if(lookupBook == null){
                        System.out.println("This book does not exist.");
                        System.out.println("The ISBN you entered: "+lookupISBN);
                        break;
                    }
                    System.out.println("Here is the book: ");
                    System.out.println(lookupBook.toString());
                    break;
                case 3://remove
                    System.out.println("What is the ISBN of the book to remove?");
                    //state.remove();
                    break;
                case 4://prints all books
                    //TODO
                    break;
                case 5://save changes
                    System.out.println("Saving now...");
                    state.save();
                    break;
                case 6://quits the application

                    break;
                case 7:
                    current.writeMenu();
                    break;
                default:
                    System.out.println("Please enter a integer in the range provided. Enter 7 to list the menu.");
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
