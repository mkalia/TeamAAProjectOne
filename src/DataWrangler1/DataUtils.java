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
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DataUtils {

    public static MapADT<Long, Book> loadData() {
        File file = getFile();
        MapADT<Long, Book> map = fillTable(file);
        return map;
    }

    public static void saveData(MapADT<Long, Book> map, ArrayList<Long> keys) {
        File file = getFile();
        file.delete();
        file = getFile();
        writeToFile(file, map, keys);
    }

    /**
     * Finds the txt file to read
     * If no appropriate file is found, a blank one is created
     * @return file The txt file to be read from
     */
    private static File getFile() {
        String filename = System.getProperty("user.dir");
        filename += "\\src\\library.txt";
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

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
            //I'm really hoping this never executes
        }
    }
}

