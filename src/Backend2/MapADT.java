import java.util.NoSuchElementException;

public interface MapADT<Book> {
    public boolean put(Long isbn, String title, String author, int rating);
    public Book get(Long isbn) throws NoSuchElementException; 
    public int size();
    public boolean containsKey(Long isbn);
    public Book remove(Long isbn);
    public void clear();
}
