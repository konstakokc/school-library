package library.DAO;

import java.util.List;
import library.model.Book;
import library.model.Loan;
import library.model.LoanID;
import library.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LoanDAOImpl implements LoanDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLoan(Loan loan) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(loan);
    }

    @Override
    public void addLoan(int studentID, int bookID) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, studentID);
        Book book = session.load(Book.class, bookID);
        Loan loan = new Loan(student, book);
        student.getBooks().add(loan);
        book.getStudents().add(loan);
        session.persist(loan);
    }

    @Override
    public void updateLoan(Loan loan) {
        Session session = sessionFactory.getCurrentSession();
        session.update(loan);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Loan> listLoans() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Loan> loans = session.createQuery("from Loan").list();
        for (Loan loan : loans) {
            System.out.println(loan.toString());
        }
        return loans;
    }

    @Override
    public Loan getLoanById(LoanID loanID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Loan.class, loanID);
    }

    @Override
    public void returnLoan(LoanID loanID) {
        Session session = sessionFactory.getCurrentSession();
        Loan loan = session.load(Loan.class, loanID);
        loan.setActive(false);
        session.update(loan);
    }

    @Override
    public void deleteLoan(LoanID loanID) {
        Session session = sessionFactory.getCurrentSession();
        Loan loan = session.get(Loan.class, loanID);
        if (loan != null) {
            session.delete(loan);
        }

    }
}
