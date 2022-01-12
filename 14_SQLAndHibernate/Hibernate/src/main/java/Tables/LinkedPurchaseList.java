package Tables;

import Keys.KeyLinkedPurchaseList;

import javax.persistence.*;


@Entity
public class LinkedPurchaseList {

    @EmbeddedId
    private KeyLinkedPurchaseList key;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;


    public KeyLinkedPurchaseList getKey() {
        return key;
    }

    public void setKey(KeyLinkedPurchaseList key) {
        this.key = key;
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
