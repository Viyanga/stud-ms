package lk.viyanga.studms.service.student;

import lk.viyanga.studms.dto.student.GuardianDTO;
import lk.viyanga.studms.dto.student.StudentDTO;
import lk.viyanga.studms.exception.StudMSException;
import lk.viyanga.studms.model.Guardian;
import lk.viyanga.studms.model.Student;
import lk.viyanga.studms.model.StudentSubject;
import lk.viyanga.studms.model.Subject;
import lk.viyanga.studms.repository.student.GuardianRepository;
import lk.viyanga.studms.repository.student.StudentRepository;
import lk.viyanga.studms.repository.subject.StudentSubjectRepository;
import lk.viyanga.studms.repository.subject.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final SubjectRepository subjectRepository;
    private final StudentSubjectRepository studentSubjectRepository;

    public StudentService(StudentRepository studentRepository, GuardianRepository guardianRepository, SubjectRepository subjectRepository, StudentSubjectRepository studentSubjectRepository) {
        this.studentRepository = studentRepository;
        this.guardianRepository = guardianRepository;
        this.subjectRepository = subjectRepository;
        this.studentSubjectRepository = studentSubjectRepository;
    }

    public void saveStudent(StudentDTO studentDTO) {
        try {
            Student student = toStudent(studentDTO);
            studentRepository.save(student);
            if (studentDTO.getGuardian() != null) {
                Guardian guardian = toGuardian(studentDTO.getGuardian());
                guardian.setStudent(student);
                guardianRepository.save(guardian);
            }
            if (studentDTO.getSubjectIds() != null) {
                for (Integer subject : studentDTO.getSubjectIds()) {
                    Optional<Subject> byId = subjectRepository.findById(subject);
                    byId.ifPresent(value -> studentSubjectRepository.save(new StudentSubject(student, value)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new StudMSException(e);
        }
    }

    public StudentDTO findByStudentId(int studentId) {
        try {
            Optional<Student> byId = studentRepository.findById(studentId);
            if (!byId.isPresent()) throw new StudMSException("Student not found");
            return toStudent(byId.get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new StudMSException(e);
        }
    }


    private StudentDTO toStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setStudentName(student.getStudentName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setContactNumber(student.getContactNumber());
        studentDTO.setStudentNIC(student.getStudentNIC());
        studentDTO.setGender(student.getGender());
        studentDTO.setYear(student.getYear());
        Optional<Guardian> byStudentId = guardianRepository.findByStudentId(student.getStudentId());
        byStudentId.ifPresent(guardian -> studentDTO.setGuardian(toGuardian(guardian)));
        studentDTO.setSubjects(studentSubjectRepository.findByStudentId(student.getStudentId()));
        return studentDTO;
    }


    private Student toStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentName(studentDTO.getStudentName());
        student.setAddress(studentDTO.getAddress());
        student.setContactNumber(studentDTO.getContactNumber());
        student.setStudentNIC(studentDTO.getStudentNIC());
        student.setGender(studentDTO.getGender());
        student.setYear(studentDTO.getYear());
        return student;
    }

    private Guardian toGuardian(GuardianDTO guardianDTO) {
        Guardian guardian = new Guardian();
        guardian.setGuardianName(guardianDTO.getGuardianName());
        guardian.setGuardianContactNumber(guardianDTO.getGuardianContactNumber());
        guardian.setGuardianNIC(guardianDTO.getGuardianNIC());
        return guardian;
    }

    private GuardianDTO toGuardian(Guardian guardian) {
        GuardianDTO guardianDTO = new GuardianDTO();
        guardianDTO.setGuardianId(guardian.getGuardianId());
        guardianDTO.setGuardianName(guardian.getGuardianName());
        guardianDTO.setGuardianContactNumber(guardian.getGuardianContactNumber());
        guardianDTO.setGuardianNIC(guardian.getGuardianNIC());
        return guardianDTO;
    }


    public List<StudentDTO> findAll() {
        List<Student> all = studentRepository.findAll();
        return all.stream().map(this::toStudent).collect(Collectors.toList());
    }
}
