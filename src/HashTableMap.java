
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableMap<Long,Book> implements MapADT{
	private LinkedList<Book>[] arr; 
	private int size; 
	private int capacity;
	private final double LOAD_FACTOR = 0.8;
	
	public HashTableMap(int capacity) {
		this.capacity = capacity; 
		arr = new LinkedList[capacity];
		size = 0;
	}
	
	public HashTableMap() {
		this.capacity = 10;
		arr = new LinkedList[10];
		size = 0; 
	}
	
	public int getCapacity() {
		return capacity; 
	}
	
	private void growHelper() {
		LinkedList<Book>[] copy = Arrays.copyOf(arr, capacity*2);
		arr=copy;
		capacity = capacity*2;
	}
		
	public void grow() {
		growHelper();
	}

	@Override
	public boolean put(java.lang.Long isbn, String title, String author, int rating) {
		
		int hashedIsbn = java.lang.Math.abs(isbn.hashCode()) % capacity; 
		Book book = new Book(isbn, title, author, rating);
		if (arr[hashedIsbn] == null) {
			arr[hashedIsbn] = new LinkedList<Book>(); 
			arr[hashedIsbn].add(book);
			size++;
			if ((double)size/capacity >= LOAD_FACTOR){
				grow();
			}
			return true;
		}
		if (!containsKey(isbn)) {
			arr[hashedIsbn].add(book);
			size++; 
			if ((double)size/capacity >= LOAD_FACTOR){
				grow();
			}
			return true; 
		}
		return false;
	}

	@Override
	public Book get(java.lang.Long isbn) throws NoSuchElementException {
		if (!containsKey(isbn)) {
			throw new NoSuchElementException("Object doesn't exist");
		}
		else {
			int hashedIsbn = java.lang.Math.abs(isbn.hashCode()) % capacity; 

			for (int i = 0; i < arr[hashedIsbn].size(); i++) {
				if (arr[hashedIsbn].get(i).getIsbn().equals(isbn)) {
					return arr[hashedIsbn].get(i);
				}
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean containsKey(java.lang.Long isbn) {
		int hashedIsbn = java.lang.Math.abs(isbn.hashCode()) % capacity;
		
		if (arr[hashedIsbn] == null) {
			return false;
		}
		for (int i = 0; i < arr[hashedIsbn].size(); i++) {
			if (( arr[hashedIsbn].get(i)).getIsbn().equals(isbn)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Book remove(java.lang.Long isbn) {
		if (!containsKey(isbn)) {
			return null;
		}
		
		int hashedKey = java.lang.Math.abs(isbn.hashCode()) % capacity; 
		for (int i = 0; i < arr[hashedKey].size(); i++) {
			if (arr[hashedKey].get(i).getIsbn().equals(isbn)) {
				Book removed = arr[hashedKey].get(i);
				arr[hashedKey].remove(i);
				size--;
				return removed;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		arr = new LinkedList[capacity];
	}

	

	
	
	


	
}

