package Backend2;

// --== CS400 File Header Information ==--
// Name: Margaret Shen
// Email: mshen42@wisc.edu
// Team: AA
// Role: Backend2
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import Common.MapADT;
import DataWrangler1.DataUtils;
import DataWrangler1.MapAndKeys;

/**
 * This class represents a book object
 */
public class State {

	private MapADT<Long, Book> map;
	private ArrayList<Long> keys;

	public State(){
		MapAndKeys mk = DataUtils.loadData();
		map = mk.getHashTable();
		keys = mk.getKeys();
	}

	/**
 * @param book book object to be added
 * @return true if the book object was added, otherwise false
 */
	public boolean add(Book book) {
		boolean isValid = true; // true if the book is valid, otherwise false
		Long isbn = book.getIsbn(); // ISBN of the book object

		// checks if the isbn is correct number of digits long
		if (isbn.toString().length() != 10 && isbn.toString().length() != 13) {
			isValid = false;
		}

		// rating cannot be less than zero
		if (book.getRating() < 0) {
			isValid = false;
		}

		// checks if author and title are defined
		if (book.getAuthor() == null && book.getTitle() == null) {
			isValid = false;
		}

		// adds book to the map if it is valid
		if (isValid) {
			keys.add(isbn);
			return map.put(book.getIsbn(), book);
		}
		return false;
	}

	/**
	* given a valid key, gets a book object
 * @param isbn isbn of the book
 * @return the book object that has the isbn, otherwise returns null
 */
	public Book get(Long isbn) {
		if (map.containsKey(isbn)) {
			return map.get(isbn);
		}
		return null;
	}

	/**
	 * saves the data stored in the map into a text file
	 */
	public void save() {
		DataUtils.saveData(map, keys);
	}

	/**
	* removes and returns the book object from the map
	* @param isbn isbn of the book
  * @return the book object that is removed, returns null if the book object is not in the map
  */
	public Book remove(long isbn) {
		if (map.containsKey(isbn)){
			map.remove(isbn);
			keys.remove(isbn);
		}
		return null;
	}

	/**
	 * converts all the stored book objects into a printable string
	 */
	@Override
	public String toString(){
		String allBooks = "";
		for (int i = 0; i < keys.size(); i++) {
			allBooks = allBooks + map.get(keys.get(i)).toString();
		}
		return allBooks;
	}

}
