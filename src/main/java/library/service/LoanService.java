package library.service;

import java.util.List;
import library.model.Book;
import library.model.Loan;
import library.model.LoanID;
import library.model.Student;

public interface LoanService {
    void addLoan(Loan loan);
    void addLoan(int studentID, int bookID);
    void updateLoan(Loan loan);
    List<Loan> listLoans();
    Loan getLoanById(LoanID loanID);
    void returnLoan(LoanID loanID);
    void deleteLoan(LoanID loanID);
}
