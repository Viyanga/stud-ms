package lk.viyanga.studms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Entity
public class Subject {
    @Id
    private int subjectId;
    private String subject;

    public Subject() {
    }

    public Subject(int subjectId, String subject) {
        this.subjectId = subjectId;
        this.subject = subject;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
