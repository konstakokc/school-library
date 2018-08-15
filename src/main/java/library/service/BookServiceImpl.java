package library.service;

import java.util.List;
import library.DAO.BookDAO;
import library.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Transactional
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Transactional
    public List<Book> listBooks() {
        return this.bookDAO.listBooks();
    }

    @Transactional
    public Book getBookById(int id) {
        return this.bookDAO.getBookById(id);
    }

    @Transactional
    public void deleteBook(int id) {
        this.bookDAO.deleteBook(id);
    }
}
