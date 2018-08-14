package library.DAO;

import java.util.List;
import library.model.Student;

public interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(Student student);
    List<Student> listStudents();
    Student getStudentById(int id);
    void deleteStudent(int id);
}
