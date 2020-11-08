package lk.viyanga.studms.dto.subject;

/**
 * @author - Anuradha Ranasinghe on 2020-11-06
 * @project - stud-ms
 **/
public class StudentSubjectDTO {

    private int studentSubjectTestId;
    private String studentName;
    private String subject;
    private String contactNumber;
    private int mark;

    public StudentSubjectDTO(int studentSubjectTestId, String studentName, String subject, String contactNumber, int mark) {
        this.studentSubjectTestId = studentSubjectTestId;
        this.studentName = studentName;
        this.subject = subject;
        this.contactNumber = contactNumber;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StudentSubjectDTO{" +
                "studentSubjectTestId=" + studentSubjectTestId +
                ", studentName='" + studentName + '\'' +
                ", subject='" + subject + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", mark=" + mark +
                '}';
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
