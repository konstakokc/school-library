package library.DAO;

import java.util.List;
import library.model.Loan;
import library.model.LoanID;
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
        Loan loan = session.get(Loan.class, loanID);
        return loan;
    }

    @Override
    public void deleteLoan(int id) {
        Session session = sessionFactory.getCurrentSession();
        Loan loan = session.get(Loan.class, id);
        if (loan != null) {
            session.delete(loan);
        }

    }
}
