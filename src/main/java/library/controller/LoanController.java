package library.controller;

import library.model.Loan;
import library.model.LoanID;
import library.service.BookService;
import library.service.LoanService;
import library.service.StudentService;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/loan")
public class LoanController {
    private StudentService studentService;
    private BookService bookService;
    private LoanService loanService;

    @Autowired
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    @Qualifier(value = "loanService")
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping(value = "/loans")
    public String loans(Model model) {
        model.addAttribute("listLoans", this.loanService.listLoans());
        return "loans";
    }

    @RequestMapping(value = "")
    public String loan(Model model) {

        model.addAttribute("listStudents", this.studentService.listStudents());
        model.addAttribute("listBooks", this.bookService.listBooks());
        model.addAttribute("studbookID", new MutablePair());

        return "loan";
    }

    @PostMapping(value = "/add")
    public String addLoan(@ModelAttribute("studbookID") MutablePair<String, String> studbookID) {
        this.loanService.addLoan(Integer.parseInt(studbookID.left), Integer.parseInt(studbookID.right));
        return "redirect:/loan/loans";
    }

    @RequestMapping(value = "/returnPage/{loanID}")
    public String returnLoan(@PathVariable("loanID") LoanID loanID, Model model) {
        Loan loan = this.loanService.getLoanById(loanID);
        model.addAttribute("loan", loan);
        model.addAttribute("debt", loan.calculateDebt());

        return "returnLoan";
    }

    @RequestMapping(value = "/return/{loanID}")
    public String returnLoan(@PathVariable("loanID") LoanID loanID) {
        this.loanService.returnLoan(loanID);

        return "redirect:/loan/loans";
    }
}
