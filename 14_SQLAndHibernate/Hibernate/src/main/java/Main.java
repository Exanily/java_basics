import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static final Metadata METADATA = new MetadataSources(REGISTRY).getMetadataBuilder().build();
    private static final SessionFactory SESSION_FACTORY = METADATA.getSessionFactoryBuilder().build();
    private static final Session SESSION = SESSION_FACTORY.openSession();
    private static final Transaction TRANSACTION = SESSION.beginTransaction();

    public static void main(String[] args) {
        Course course = SESSION.get(Course.class, 47);
        Student student = new Student();
        student.setName("ASD");
        Subscription subscription = new Subscription();
        subscription.setCourse(course);
        subscription.setStudent(student);
        SESSION.save(course);
        TRANSACTION.commit();
        SESSION_FACTORY.close();
    }
}
