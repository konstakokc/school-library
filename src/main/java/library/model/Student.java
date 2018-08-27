package library.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Student")
@Table(name = "student")
public class Student extends Person {

    @Column(name = "class")
    private String group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> books = new ArrayList<>();

    public List<Loan> getBooks() {
        return books;
    }

    public void setBooks(List<Loan> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        Loan loan = new Loan(this, book);
        books.add(loan);
        book.getStudents().add(loan);
    }

    public void deleteBook(Book book) {

    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
