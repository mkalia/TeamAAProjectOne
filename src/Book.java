
public class Book {
	
	private Long isbn; // book's isbn number 
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
	
	public String getTitle() {
		return title; 
	}
	
	public String getAuthor() {
		return author; 
	}
	
	public int getRating() {
		return rating;
	}
	
	public Long getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Long isbn) {
		this.isbn = isbn; 
	}
	
	public void setRating(Integer rating) {
		this.rating = rating; 
	}

}
