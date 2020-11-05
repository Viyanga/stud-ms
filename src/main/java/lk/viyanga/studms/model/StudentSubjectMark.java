package lk.viyanga.studms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author - Anuradha Ranasinghe on 2020-11-06
 * @project - stud-ms
 **/
@Entity
public class StudentSubjectMark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentSubjectTestId;
    private String studentName;
    private String subject;
    private String contactNumber;
    private int mark;

    public StudentSubjectMark() {
    }


    public int getStudentSubjectTestId() {
        return studentSubjectTestId;
    }

    public void setStudentSubjectTestId(int studentSubjectTestId) {
        this.studentSubjectTestId = studentSubjectTestId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
