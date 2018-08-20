package library.service;

import java.util.List;
import library.DAO.LoanDAO;
import library.model.Loan;
import library.model.LoanID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    private LoanDAO loanDAO;

    public void setLoanDAO(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    @Transactional
    public void addLoan(Loan loan) {
        this.loanDAO.addLoan(loan);
    }

    @Transactional
    public void updateLoan(Loan loan) {
        this.loanDAO.updateLoan(loan);
    }

    @Transactional
    public List<Loan> listLoans() {
        return this.loanDAO.listLoans();
    }

    @Transactional
    public Loan getLoanById(LoanID loanID) {
        return this.loanDAO.getLoanById(loanID);
    }

    @Transactional
    public void deleteLoan(int id) {
        this.loanDAO.deleteLoan(id);
    }
}
