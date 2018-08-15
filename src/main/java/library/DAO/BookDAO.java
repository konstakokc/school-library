package library.DAO;

import java.util.List;
import library.model.Book;

public interface BookDAO {
    void addBook(Book book);
    void updateBook(Book book);
    List<Book> listBooks();
    Book getBookById(int id);
    void deleteBook(int id);
}
