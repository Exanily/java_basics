package Keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KeyLinkedPurchaseList implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public KeyLinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public KeyLinkedPurchaseList() {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
