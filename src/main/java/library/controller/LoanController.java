package library.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import library.model.Book;
import library.model.Loan;
import library.model.LoanID;
import library.model.Student;
import library.service.BookService;
import library.service.LoanService;
import library.service.StudentService;
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

    @RequestMapping(value = "/loan")
    public String loan(Model model) {

        Map<String, String> students = new HashMap<>();
        for (Student student : studentService.listStudents()) {
            students.put(String.valueOf(student.getId()), student.getFirstName() + " " + student.getLastName());
        }
        model.addAttribute("listStudents", students);

        Map<String, String> books = new HashMap<>();
        for (Book book : bookService.listBooks()) {
            books.put(String.valueOf(book.getId()), book.getName());
        }
        model.addAttribute("listBooks", books);

        model.addAttribute("loan", new Loan());

        return "loan";
    }

    @PostMapping(value = "/loan/add")
    public String addLoan(@ModelAttribute("loan") Loan loan) {
        loan.setActive(true);
        loan.setStartDate(LocalDate.now());
        this.loanService.addLoan(loan);
        return "redirect:/loans";
    }

    @RequestMapping(value = "/loan/return/{loanID}")
    public String returnLoan(@PathVariable("loanID") LoanID loanID) {

        //-------------------------//
        //Return logic HERE (date)
        //-------------------------//

        Loan toBeReturned = this.loanService.getLoanById(loanID);
        toBeReturned.setActive(false);
        this.loanService.updateLoan(toBeReturned);
        return "redirect:/loans";
    }
}
