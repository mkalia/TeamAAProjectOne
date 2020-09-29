package Backend2;

import java.util.ArrayList;

import Common.MapADT;
import DataWrangler2.DataUtils;

public class State {
	
	private MapADT<Book> map = DataUtils.loadData(); 
	private ArrayList<Long> keys = new ArrayList<>();
	
	public boolean add(Book book) {
		boolean isValid = true; 
		Long isbn = book.getIsbn();
		
		// checks if the isbn is correct 
		if (isbn.toString().length() != 10 || isbn.toString().length() != 13) {
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
			return map.put(book.getIsbn(), book);
		}
		return false;
	}
	
	// gets book out of the map 
	public Book get(Long isbn) {
		if (map.containsKey(isbn)) {
			return map.get(isbn);
		}
		return null;
	}
	
	// saves the books in the map into a txt file
	public void save() {
		DataUtils.saveData(map, keys); 
	}

	public Book remove(long l) {
		return null;
	}
	

}
