// --== CS400 File Header Information ==--
// Name: Grant Parfrey
// Email: gparfrey@wisc.edu
// Team: AA
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader: Some functionality might not be working due to other roles.
package FrontEnd1;
import java.util.Scanner;
import Backend2.Book;
import Backend2.State;


public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//using the scanner for inputs from the terminal
        App current = new App();
        State state = new State();
        System.out.println("Welcome to the Online Book Catalog!");
        System.out.println("This program stores ISBN's, book titles, authors, and ratings.");
        System.out.println("To interact, simply enter the number (integer only) that corresponds to the menu item you want.");

        int i = -998;//initializing the variable that will control the flow of the program
        while (i != 6) {//runs until 6 because that is the value that the user will enter to end the program
            if(i==-998){//see if this is the first time that the program is run
                current.writeMenu();
            }else{//if this is not the first time it is run, that means the user just got back to the menu
                System.out.println("You are now back to the menu. Enter your desired task. Enter 7 to see menu options.");
            }
            if (!input.hasNextInt()) {
                i = -2;//if the user does not enter an int, it goes to the default case and makes the user try again
                input.nextLine();//buffer clear so that it does not get stuck in an infinite loop
            } else {
                i = input.nextInt();
            }
            switch (i) {//Switch structure for operating the menu
                case 1: //add a new book
                    System.out.println("Adding a new book!");
                    System.out.println("Please enter the ISBN, making sure it is 10 or 13 digits long.");
                    if(!input.hasNextLong()) {//data format validation
                        input.nextLine();
                        System.out.println("A long value type was not found. Please try adding a new book again.");
                        break;
                    }
                    Long tempISBN = input.nextLong();
                    String stringISBN = tempISBN.toString();
                    if(stringISBN.length() != 10 && stringISBN.length() != 13){//data format validation
                        System.out.println("The length you entered was: "+stringISBN.length());
                        System.out.println("Please try adding a book again with the correct length of 10 or 13");
                        break;
                    }
                    System.out.println("Please enter the title in the form of a string.");
                    input.nextLine();//buffer due to adding a long above
                    if(!input.hasNextLine()) {//data format validation
                        input.nextLine();
                        System.out.println("A String value type was not found. Please try adding a new book again.");
                        break;
                    }
                    String tempTitle = input.nextLine();
                    System.out.println("Please enter the Author in the form of a string.");
                    if(!input.hasNextLine()) {//data format validation
                        input.nextLine();
                        System.out.println("A String value type was not found. Please try adding a new book again.");
                        break;
                    }
                    String tempAuthor = input.nextLine();
                    System.out.println("Please enter the rating in the form of an integer. Must be zero or greater.");
                    if(!input.hasNextInt()) {//data format validation
                        input.nextLine();
                        System.out.println("A integer value type was not found. Please try adding a new book again.");
                        break;
                    }
                    int tempRating = input.nextInt();
                    if(tempRating < 0 || tempRating > 5){//making sure rating is bounded between 0-5
                        System.out.println("This is not a valid rating. Please try adding a book again.");
                        break;
                    }
                    Book tempBook = new Book(tempISBN, tempTitle, tempAuthor, tempRating);//creating the book to add to the list
                    if(state.add(tempBook)){
                        System.out.println("Congratulations, the following book has been added:");
                        System.out.println(tempBook.toString());//printing the book that was added
                    }else{//if state.add returns false, one of the requirements was not met.
                        System.out.println("Something went wrong.");
                        System.out.println("Common errors:");
                        System.out.println("The ISBN already exists.");
                        /*
                        The state does not define a difference in returning false due to an ISBN already existing.
                        Therefore, this cannot be confident if that was the error that was made or one of the
                        tests in the state did not pass when trying to add the book.
                         */
                    }
                    break;
                case 2://lookup
                    System.out.println("Please enter the ISBN of the book you are trying to find.");
                    if(!input.hasNextLong()) {//data format validation
                        input.nextLine();
                        System.out.println("A long value type was not found.");
                        break;
                    }
                    Long lookupISBN = input.nextLong();
                    if(lookupISBN.toString().length() != 10 && lookupISBN.toString().length() != 13){//data format validation
                        System.out.println("The length you entered was: "+lookupISBN.toString().length());
                        System.out.println("Please try adding a book again with the correct length of 10 or 13");
                        break;
                    }
                    Book lookupBook = state.get(lookupISBN);
                    if(lookupBook == null){//checking if the state returned null, meaning the data does not exist
                        System.out.println("This book does not exist.");
                        System.out.println("The ISBN you entered: "+lookupISBN);
                        break;
                    }
                    System.out.println("Here is the book:");//the state did not return null, meaning that the book exists
                    System.out.println(lookupBook.toString());
                    break;
                case 3://remove
                    System.out.println("What is the ISBN of the book to remove?");
                    if(!input.hasNextLong()) {//data format validation
                        input.nextLine();
                        System.out.println("A long value type was not found.");
                        break;
                    }
                    Long removeISBN = input.nextLong();
                    if(removeISBN.toString().length() != 10 && removeISBN.toString().length() != 13){//data format validation
                        System.out.println("The length you entered was: "+removeISBN.toString().length());
                        System.out.println("Please try adding a book again with the correct length of 10 or 13.");
                        break;
                    }
                    Book removedBook = state.remove(removeISBN);//retrieves the book that it removes
                    if(removedBook == null){//the state will return null if the book does not exist
                        System.out.println("That book does not exist.");
                    }else{
                        System.out.println("Here is the book that you removed:");
                        System.out.println(removedBook.toString());//prints the book that was returned/removed
                    }
                    break;
                case 4://prints all books
                    System.out.println("Printing books now...");
                    System.out.println(state.toString());//state should return a toString of all the books in the state
                    break;
                case 5://save changes
                    System.out.println("Saving now...");
                    state.save();//data wranglers job
                    break;
                case 6://quits the application
                    //the while loop will quit once it compares the int i to 6
                    break;
                case 7://write the  menu to the screen
                    current.writeMenu();
                    break;
                default://the integer entered was not in the range of the menu
                    System.out.println("Please enter a integer in the range provided. Enter 7 to list the menu.");
                    break;
            }
        }
    }

    /**
     * Writes the menu to the terminal
     */
    private void writeMenu(){
        System.out.println("1: Add new book");
        System.out.println("2: Lookup a book from a ISBN");
        System.out.println("3: Remove a book");
        System.out.println("4: Print all the book data");
        System.out.println("5: Save local changes to .txt file");
        System.out.println("6: Quit the application WITHOUT saving changes");
        System.out.println("7: List menu again");
    }
}
