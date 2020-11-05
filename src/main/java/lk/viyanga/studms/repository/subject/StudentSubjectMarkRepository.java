package lk.viyanga.studms.repository.subject;

import lk.viyanga.studms.dto.subject.StudentSubjectDTO;
import lk.viyanga.studms.model.StudentSubjectMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-11-06
 * @project - stud-ms
 **/
public interface StudentSubjectMarkRepository extends JpaRepository<StudentSubjectMark,Integer> {

    @Query("SELECT s FROM StudentSubjectMark s WHERE s.studentName=?1 AND s.subject=?2")
    Optional<StudentSubjectMark> findByStudentAndSubject(String studentName, String subject);

    @Query("SELECT new lk.viyanga.studms.dto.subject.StudentSubjectDTO(s.studentName,s.subject,s.contactNumber,s.mark) FROM StudentSubjectMark s")
    List<StudentSubjectDTO> getAll();

}
