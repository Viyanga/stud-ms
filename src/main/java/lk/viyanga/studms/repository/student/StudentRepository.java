package lk.viyanga.studms.repository.student;

import lk.viyanga.studms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.studentName=?1")
    Optional<Student> findByName(String name);

}
