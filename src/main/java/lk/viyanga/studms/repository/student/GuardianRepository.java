package lk.viyanga.studms.repository.student;

import lk.viyanga.studms.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public interface GuardianRepository extends JpaRepository<Guardian, Integer> {

    @Query("SELECT g FROM Guardian g WHERE g.student.studentId=?1")
    Optional<Guardian> findByStudentId(int studentId);

}
