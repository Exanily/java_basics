import Keys.KeyLinkedPurchaseList;
import Tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static final Metadata METADATA = new MetadataSources(REGISTRY).getMetadataBuilder().build();
    private static final SessionFactory SESSION_FACTORY = METADATA.getSessionFactoryBuilder().build();
    private static final Session SESSION = SESSION_FACTORY.openSession();
    private static final Transaction TRANSACTION = SESSION.beginTransaction();

    public static void main(String[] args) {
        String hqlPurchaseLists = "from " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = SESSION.createQuery(hqlPurchaseLists).getResultList();


        String hqlStudent = "from " + Student.class.getSimpleName();
        List<Student> students = SESSION.createQuery(hqlStudent).getResultList();

        String hqlCourse = "from " + Course.class.getSimpleName();
        List<Course> courses = SESSION.createQuery(hqlCourse).getResultList();

        for (PurchaseList purchaseList : purchaseLists) {
            int studentId = searchStudentId(students, purchaseList.getStudentName());
            int courseId = searchCourseId(courses, purchaseList.getCourseName());

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setCourseId(courseId);
            linkedPurchaseList.setStudentId(studentId);
            linkedPurchaseList.setKey(new KeyLinkedPurchaseList(studentId, courseId));
            SESSION.save(linkedPurchaseList);
        }
        TRANSACTION.commit();
        SESSION_FACTORY.close();
    }

    private static int searchStudentId(List<Student> students, String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getId();
            }
        }
        return -1;
    }

    private static int searchCourseId(List<Course> courses, String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course.getId();
            }
        }
        return -1;
    }
}
