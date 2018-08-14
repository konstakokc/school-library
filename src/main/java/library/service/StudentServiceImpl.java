package library.service;

import java.util.List;
import library.DAO.StudentDAO;
import library.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    public void addStudent(Student student) {
        this.studentDAO.addStudent(student);
    }

    @Transactional
    public void updateStudent(Student student) {
        this.studentDAO.updateStudent(student);
    }

    @Transactional
    public List<Student> listStudents() {
        return this.studentDAO.listStudents();
    }

    @Transactional
    public Student getStudentById(int id) {
        return this.studentDAO.getStudentById(id);
    }

    @Transactional
    public void deleteStudent(int id) {
        this.studentDAO.deleteStudent(id);
    }
}
