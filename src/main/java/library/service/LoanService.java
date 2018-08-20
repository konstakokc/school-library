package library.service;

import java.util.List;
import library.model.Loan;
import library.model.LoanID;

public interface LoanService {
    void addLoan(Loan loan);
    void updateLoan(Loan loan);
    List<Loan> listLoans();
    Loan getLoanById(LoanID loanID);
    void deleteLoan(int id);
}
