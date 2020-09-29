package Backend2;

// --== CS400 File Header Information ==--
// Name: Margaret Shen
// Email: mshen42@wisc.edu
// Team: AA
// Role: Backend2
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * This class represents a book object
 */
public class Book {

	private Long isbn; // book's ISBN number
	private String title; // book's title
	private String author; // book's author
	private int rating; // rating out of 5

	/**
	 * Book constructor version 1
	 * @param isbn ISBN of the book
	 * @param title title of the book
	 * @param author author of the book
	 */
	public Book(Long isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.rating = 0;
	}

/**
 * Book consturctor version 2
 * @param isbn ISBN of the book
 * @param title title of the book
 * @param author author of the book
 * @param rating rating of the book
 */
	public Book(Long isbn, String title, String author, int rating) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.rating = rating;
	}

	/**
	 * get the ISBN of the book
	 * @return isbn of the book
	 */
	public Long getIsbn() {
		return isbn;
	}

	/**
	 * get the title of the book
	 * @return title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * get the author of the book
	 * @return author of the book
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * get the rating of the book
	 * @return rating of the book
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * set the rating of the book
	 * @param rating rating that you want to give to the book
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * set the author of the book
	 * @param author author of the book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * set the title of the book
	 * @param title title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns a string version that contains the book information
	 */
	@Override
	public String toString() {
	    return "ISBN: " +  isbn + "\nTitle: " + title + "\nAuthor: " + author + "\nRating: " + rating + "\n";
	}

}
