package lk.viyanga.studms.model;

import javax.persistence.*;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"studentId", "subjectId"})})
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentSubjectId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subjectId")
    private Subject subject;

    public StudentSubject() {
    }

    public StudentSubject(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
    }

    public int getStudentSubjectId() {
        return studentSubjectId;
    }

    public void setStudentSubjectId(int studentSubjectId) {
        this.studentSubjectId = studentSubjectId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
