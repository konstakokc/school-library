import library.model.Book;
import library.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        try (Session session = getSession()) {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();

            session.beginTransaction();

//            Student student1 = new Student();
//            student1.setFirstName("Vasya");
//            student1.setLastName("Petrov");
//            student1.setGroup("2B");
//
//            Book book1 = new Book();
//            book1.setName("Optional");
//            book1.setAuthor("auth");
//            book1.setGenre("non");
//            book1.setCountry("TV");

//            session.persist(book1);
//            student1.addBook(book1);

            Student student1 = session.get(Student.class, 1);
            student1.addBook(session.get(Book.class, 2));

            session.persist(student1);

            session.getTransaction().commit();

            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        }
    }
}