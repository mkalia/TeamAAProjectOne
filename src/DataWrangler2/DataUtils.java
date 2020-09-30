package DataWrangler2;
// --== CS400 File Header Information ==--

// Name: Christopher Nguyen
// Email: cnguyen29@wisc.edu
// Team: AA
// Role: Data Wrangler
// TA: Sophie Stephenson
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Backend2.Book;

import Common.HashTableMap;
import Common.MapADT;

public class DataUtils {
  private static File file;
  
  private static void getFile() {
    String fileName = System.getProperty("user.dir");
    fileName += "\\src\\library.txt";
    file = new File (fileName);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch(IOException e) {
        e.getMessage();
      }
    }
  }
  /**
   * Helper method for scanning through txt file
   * @param scnr
   * @return
   */
  private static Book getInfo(Scanner scnr) {
    String title = scnr.nextLine();
    String author = scnr.nextLine();
    String isbnString = scnr.nextLine();
    Long isbn = Long.valueOf(isbnString); //converts String to Long
    String ratingString = scnr.nextLine();
    int rating = Integer.parseInt(ratingString); //converts String to int
    Book book = new Book(isbn, title, author, rating);
    return book;
  }
  
  private static void clearFile() {
    try{
      PrintWriter print = new PrintWriter(file);
      print.print("");
      print.close();
    } catch(IOException e) {
      e.getMessage();
    }

}
  
  /**
   * Reads from txt file and puts values into the map
   * @return
   * @throws IOException 
   */
  public static MapADT<Long,Book> loadData() {
    MapADT<Long, Book> hashTable = new HashTableMap<>();
    try {
    getFile();
    Scanner scnr = new Scanner(file);
    while (scnr.hasNext()) {
        Book book = getInfo(scnr);
        hashTable.put(book.getIsbn(), book);
    }
    scnr.close();
    } catch(IOException e) {
      e.getMessage();
    }
    return hashTable;
  }
  
  /**
   * Writes to the txt file that is used whenever the program is run again
   * @param map
   * @throws FileNotFoundException 
   */
  public static void saveData(MapADT<Long,Book> map, ArrayList<Long> keys){
    getFile();
    clearFile();
    try {
    PrintWriter writer = new PrintWriter(file);
    for (int i = 0; i < keys.size(); i++) {
      Book book = map.remove(keys.get(i));
      writer.println(book.getTitle());
      writer.println(book.getAuthor());
      writer.println(book.getIsbn());
      writer.println(book.getRating());
    }
    writer.close();
    } catch(IOException e) {
      e.getMessage();
    }
  }
  
}
