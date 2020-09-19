package lk.viyanga.studms.repository.student;

import lk.viyanga.studms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
