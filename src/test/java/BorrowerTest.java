import com.codebase.Book;
import com.codebase.Borrower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class BorrowerTest {
    Book book;
    Borrower borrower;
    @Before
    public void before(){
        book = new Book("Dune", "Frank Herbert", "Sci-Fi");
        borrower = new Borrower("Rob");
    }

    @Test
    public void numberBooksLent(){
        assertEquals(0, borrower.borrowAmount());
    }
    @Test
    public void canAddBook(){
        borrower.addBook(book);
        assertEquals(1, borrower.borrowAmount());
    }

}
