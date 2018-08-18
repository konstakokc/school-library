package library.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "Loan")
@Table(name = "loan")
public class Loan {

    @EmbeddedId
    private LoanID loanID;

    @ManyToOne
    @MapsId("studentID")
//    @JoinColumn(name = "id")
    private Student student;

    @ManyToOne
    @MapsId("bookID")
    private Book book;

    private LocalDate startDate;
    private boolean active;

    public Loan() {}

    public Loan(Student student, Book book) {
        this.student = student;
        this.book = book;
        this.loanID = new LoanID(student.getId(), book.getId());
        this.startDate = LocalDate.now();
        this.active = true;
    }

    public LoanID getLoanID() {
        return loanID;
    }

    public void setLoanID(LoanID loanID) {
        this.loanID = loanID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Loan)) {
            return false;
        }
        Loan loan = (Loan) o;
        return active == loan.active &&
                Objects.equals(student, loan.student) &&
                Objects.equals(book, loan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, book, active);
    }
}
