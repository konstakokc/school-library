package library.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends Person {

    @Column(name = "group")
    private String group;


    private List<Loan> loans;
}
