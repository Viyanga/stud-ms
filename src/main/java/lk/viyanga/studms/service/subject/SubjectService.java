package lk.viyanga.studms.service.subject;

import lk.viyanga.studms.dto.subject.StudentSubjectDTO;
import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.exception.StudMSException;
import lk.viyanga.studms.model.StudentSubjectMark;
import lk.viyanga.studms.repository.subject.StudentSubjectMarkRepository;
import lk.viyanga.studms.repository.subject.SubjectRepository;
import lk.viyanga.studms.service.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Service
public class SubjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);

    private final SubjectRepository subjectRepository;
    private final StudentSubjectMarkRepository studentSubjectMarkRepository;
    private final MailSender mailSender;

    public SubjectService(SubjectRepository subjectRepository, StudentSubjectMarkRepository studentSubjectMarkRepository, MailSender mailSender) {
        this.subjectRepository = subjectRepository;
        this.studentSubjectMarkRepository = studentSubjectMarkRepository;
        this.mailSender = mailSender;
    }

    public List<SubjectDTO> findAll() {
        return subjectRepository.findAllSubjects();
    }

    public void addMark(StudentSubjectDTO studentSubjectDTO) {
        if (studentSubjectDTO.getStudentName() == null) {
            throw new StudMSException("Student name is empty");
        }
        if (studentSubjectDTO.getSubject() == null) {
            throw new StudMSException("Subject name is empty");
        }
        if (studentSubjectDTO.getContactNumber() == null) {
            throw new StudMSException("Contact number is empty");
        }
        Optional<StudentSubjectMark> subject = studentSubjectMarkRepository.findByStudentAndSubject(studentSubjectDTO.getStudentName(), studentSubjectDTO.getSubject());
        StudentSubjectMark studentSubjectMark;
        if (subject.isPresent()) {
            studentSubjectMark = subject.get();
        } else {
            studentSubjectMark = new StudentSubjectMark();
            studentSubjectMark.setStudentName(studentSubjectDTO.getStudentName());
            studentSubjectMark.setContactNumber(studentSubjectDTO.getContactNumber());
            studentSubjectMark.setSubject(studentSubjectDTO.getSubject());
        }
        studentSubjectMark.setMark(studentSubjectDTO.getMark());
        studentSubjectMarkRepository.save(studentSubjectMark);
    }

    public List<StudentSubjectDTO> findAllTestMarks() {
        return studentSubjectMarkRepository.getAll();
    }

    public StudentSubjectDTO findMarkById(int studentSubjectTestId) {
        return studentSubjectMarkRepository.findMarkById(studentSubjectTestId);
    }

    public void sendMarks(int studentSubjectTestId) {
        Optional<StudentSubjectMark> byId = studentSubjectMarkRepository.findById(studentSubjectTestId);
        if (!byId.isPresent()) {
            LOGGER.info("SubjectService | sendMarks | student marks not found");
            return;
        }
        String body = "Student name : " + byId.get().getStudentName() + "\n" +
                "Subject : " + byId.get().getSubject() + "\n" +
                "Marks : " + byId.get().getMark() + "\n";
        mailSender.send(byId.get().getContactNumber(), "Exam Results", body);
    }
}
