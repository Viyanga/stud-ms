package lk.viyanga.studms.dto.subject;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public class SubjectDTO {

    private int subjectId;
    private String subject;

    public SubjectDTO() {
    }

    public SubjectDTO(int subjectId, String subject) {
        this.subjectId = subjectId;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subjectId=" + subjectId +
                ", subject='" + subject + '\'' +
                '}';
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
