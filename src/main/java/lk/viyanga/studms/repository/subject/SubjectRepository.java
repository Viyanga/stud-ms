package lk.viyanga.studms.repository.subject;

import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query("SELECT new lk.viyanga.studms.dto.subject.SubjectDTO(s.subjectId,s.subject) FROM Subject s")
    List<SubjectDTO> findAllSubjects();
}
