package library.service;

import java.util.List;
import library.model.Book;

public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    List<Book> listBooks();
    Book getBookById(int id);
    void deleteBook(int id);
}
