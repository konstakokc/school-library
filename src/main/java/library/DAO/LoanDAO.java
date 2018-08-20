package library.DAO;

import java.util.List;
import library.model.Loan;
import library.model.LoanID;

public interface LoanDAO {
    void addLoan(Loan loan);
    void updateLoan(Loan loan);
    List<Loan> listLoans();
    Loan getLoanById(LoanID loanID);
    void deleteLoan(int id);
}
