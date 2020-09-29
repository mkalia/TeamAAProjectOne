package Backend2;

public class Book {
	
	private Long isbn;
	private String title; // book's title 
	private String author; // book's author 
	private int rating; // rating out of 5 
	
	public Book(Long isbn, String title, String author) { 
		this.isbn = isbn;
		this.title = title; 
		this.author = author; 
		this.rating = 0;
	}
	
	public Book(Long isbn, String title, String author, int rating) { 
		this.isbn = isbn;
		this.title = title; 
		this.author = author; 
		this.rating = rating;
	}
	
	public Long getIsbn() {
		return isbn; 
	}
	
	public String getTitle() {
		return title; 
	}
	
	public String getAuthor() {
		return author; 
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating; 
	}
	
	public void setAuthor(String author) {
		this.author = author; 
	}
	
	public void setTitle(String title) {
		this.title = title; 
	}
	
	@Override
	public String toString() {
	    return "ISBN: " +  isbn + "Title: " + title + "\nAuthor: " + author + "\nRating: " + rating + "\n";
	}

}
