package DataWrangler1;
// --== CS400 File Header Information ==--
// Name: Owen Krueger
// Email: odkrueger@wis.edu
// Team: AA
// Role: DataWrangler1
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader: None

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import Backend2.Book;

import Common.HashTableMap;
import Common.MapADT;

/**
 * Class DataUtils
 * This is the class created to perform the duties of the Data Wrangler
 * It collects, cleans, and loads data into the hash table to be used
 * by the rest of the team members
 */
public class DataUtils {

    /**
     * This method collects any Books that were saved to the
     * text file to be used in between sessions
     * Then it loads all of those Objects into the hash table
     * @return map The HashTableMap to be used
     */
    public static MapADT<Long, Book> loadData() {
        File file = getFile();
        MapADT<Long, Book> map = fillTable(file);
        return map;
    }

    /**
     * This method writes all of the Book objects from the
     * hash table into the text file to be used next time
     * @param map The hash table
     * @param keys An arraylist of the keys of the hash table
     */
    public static void saveData(MapADT<Long, Book> map, ArrayList<Long> keys) {
        File file = getFile();
        file.delete();
        file = getFile();
        writeToFile(file, map, keys);
    }

    /**
     * Private helper method
     * Finds "library.txt" in the current directory, to use
     * for reading and writing
     * If no such file exists, a blank one is created
     * @return file The text file
     */
    private static File getFile() {
        String filename = System.getProperty("user.dir");
        filename += "\\src\\library.txt";
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
        return file;
    }

    /**
     * Private helper method
     * Takes input from the text file, and loads the
     * data into the hash table
     * @param file The text file to be read
     * @return map The hash table map
     */
    private static MapADT<Long, Book> fillTable(File file) {
        MapADT<Long, Book> map = new HashTableMap<>(); //create a new hash table to return
        try {
            Scanner reader = new Scanner(file);//to read file; This is the only place for an
            //exception to be thrown in this method
            boolean done = false;
            while (!done) {
                if (!reader.hasNextLine())//if there is no more input
                    done = true;
                else {
                    try {
                        String title = reader.nextLine().trim();
                        String author = reader.nextLine().trim();
                        Long isbn = Long.parseLong(reader.nextLine().trim());
                        int rating = Integer.parseInt(reader.nextLine().trim());

                        Book book = new Book(isbn, title, author, rating);

                        map.put(book.getIsbn(), book);
                    }
                    catch (Exception e) {
                        //error in .txt file format
                    }
                }
            }
            reader.close();
            return map;
        } catch (FileNotFoundException e) {
            return map; //if the file doesn't exist, then a new file was already made for
            //writing to, and an empty hash table is returned
        }
    }

    /**
     * Private helper method
     * Writes the books from the hash table into the text file
     * @param file The text file
     * @param map The hash table map
     * @param keys An arraylist of keys of the hash table
     */
    private static void writeToFile(File file, MapADT<Long, Book> map, ArrayList<Long> keys) {

        try {
            PrintWriter printer = new PrintWriter(file);
            for (int i = 0; i < keys.size(); i++) {
                Book book = map.get(keys.get(i));
                printer.println(book.getTitle());
                printer.println(book.getAuthor());
                printer.println(book.getIsbn());
                printer.println(book.getRating());
            }
            printer.close();
        } catch (FileNotFoundException e) {
            //This will only catch an exception if the file does not
            //exist, but then the getFile() method would have created a blank one
        }
    }
}

