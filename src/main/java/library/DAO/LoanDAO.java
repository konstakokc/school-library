package library.DAO;

import java.util.List;
import library.model.Loan;
import library.model.LoanID;

public interface LoanDAO {
    void addLoan(Loan loan);
    void addLoan(int studentID, int bookID);
    void updateLoan(Loan loan);
    List<Loan> listLoans();
    Loan getLoanById(LoanID loanID);
    void returnLoan(LoanID loanID);
    void deleteLoan(LoanID loanID);
}
