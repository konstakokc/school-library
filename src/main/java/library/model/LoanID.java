package library.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoanID implements Serializable {

    @Column(name = "studentID")
    private int studentID;

    @Column(name = "bookID")
    private int bookID;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public LoanID() {}

    public LoanID(int studentID, int bookID) {
        this.studentID = studentID;
        this.bookID = bookID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoanID loanID = (LoanID) o;
        return Objects.equals(studentID, loanID.studentID) &&
                Objects.equals(bookID, loanID.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, bookID);
    }
}
