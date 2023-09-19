import com.codebase.Book;
import com.codebase.Borrower;
import com.codebase.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    private Book bookA;
    private Book bookB;
    private Book bookC;
    private Book bookD;

    private Library library;

    private Borrower borrower;

    @Before
    public void before(){
        bookA = new Book("Dune", "Frank Herbert", "Sci-fi");
        bookB = new Book("Foundation", "Isaac Asimov", "Sci-fi");
        bookC = new Book("Catcher in the Rye", "J.D. Salinger", "Americana");
        bookD = new Book("Little Women", "Louise Mary Alcott", "Coming-of-age");

        library = new Library(2);

        borrower = new Borrower("Rob");
    }

    @Test
    public void hasShelfspace(){
        assertEquals(0, library.collectionSize());
    }
    @Test
    public void canAddBook(){
        library.addBookToCollection(bookA);
        assertEquals(1, library.collectionSize());
    }
    @Test
    public void canFindBook(){
        library.addBookToCollection(bookA);
        assertTrue(library.bookInStock(bookA));
    }
    @Test
    public void canLoanBook(){
        library.addBookToCollection(bookA);
        library.lendBookToBorrower(bookA, borrower);

        assertEquals(1, borrower.borrowAmount());
        assertFalse(library.bookInStock(bookA));
    }
    @Test
    public void canAddGenres(){
        library.addBookToCollection(bookA);
        library.addBookToCollection(bookB);
        library.addBookToCollection(bookC);
        library.addBookToCollection(bookD);

        assertEquals(2, library.genreCount("Sci-fi"));
    }
}
