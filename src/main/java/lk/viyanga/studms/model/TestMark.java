package lk.viyanga.studms.model;

import javax.persistence.*;

/**
 * @author - Anuradha Ranasinghe on 2020-09-20
 * @project - stud-ms
 **/
@Entity
public class TestMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testMarkId;
    private double value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjectId")
    private Subject subject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    public int getTestMarkId() {
        return testMarkId;
    }

    public void setTestMarkId(int testMarkId) {
        this.testMarkId = testMarkId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
