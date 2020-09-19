package lk.viyanga.studms.repository.subject;

import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {

    @Query("SELECT new lk.viyanga.studms.dto.subject.SubjectDTO(s.subject.subjectId,s.subject.subject) FROM StudentSubject s WHERE s.student.studentId=?1")
    List<SubjectDTO> findByStudentId(int studentId);

}
