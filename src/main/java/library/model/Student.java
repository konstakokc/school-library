package library.model;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Student extends Person {
    private String group;
    private List<Loan> loans;
}
