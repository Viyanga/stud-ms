package lk.viyanga.studms.service.subject;

import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.model.Subject;
import lk.viyanga.studms.repository.subject.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDTO> findAll(){
        return subjectRepository.findAllSubjects();
    }

}
