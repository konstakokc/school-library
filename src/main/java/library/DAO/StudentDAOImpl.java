package library.DAO;

import java.util.List;
import library.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);

    }

    @Override
    public List<Student> listStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student").list();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, id);
        if (student != null) {
            session.delete(student);
        }

    }
}
