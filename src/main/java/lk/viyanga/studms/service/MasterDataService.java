package lk.viyanga.studms.service;

import lk.viyanga.studms.model.Subject;
import lk.viyanga.studms.repository.subject.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Service
public class MasterDataService {

    private final SubjectRepository subjectRepository;

    public MasterDataService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @PostConstruct
    public void saveSubjects() {
        subjectRepository.save(new Subject(1, "Maths"));
        subjectRepository.save(new Subject(2, "Science"));
        subjectRepository.save(new Subject(3, "Commerce"));
        subjectRepository.save(new Subject(4, "Art"));
    }

}
