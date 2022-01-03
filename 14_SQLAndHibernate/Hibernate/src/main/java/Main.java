import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    private static SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    private static Session session = sessionFactory.openSession();

    public static void main(String[] args) {
        Course course = session.get(Course.class, 1);
        System.out.println(course.getName() + " - " + course.getStudentsCount());
        sessionFactory.close();
    }
}
