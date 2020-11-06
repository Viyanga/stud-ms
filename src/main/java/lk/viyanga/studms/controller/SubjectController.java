package lk.viyanga.studms.controller;

import lk.viyanga.studms.dto.subject.StudentSubjectDTO;
import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.service.subject.SubjectService;
import lk.viyanga.studms.util.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@CrossOrigin
@RestController
@RequestMapping("subject")
public class SubjectController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/findAll/subjects")
    public ResponseEntity<?> findAll() {
        LOGGER.info("request   - subject/findAll | findAll");
        List<SubjectDTO> all = subjectService.findAll();
        LOGGER.info("response  - subject/findAll | findAll | payload : {}", all);
        return sendSuccessResponse(all);
    }

    @PostMapping("add/mark")
    public ResponseEntity<?> addMark(@RequestBody StudentSubjectDTO studentSubjectDTO) {
        LOGGER.info("request   - add/mark | addMark | payload : {}", studentSubjectDTO);
        subjectService.addMark(studentSubjectDTO);
        LOGGER.info("response  - add/mark | addMark | success");
        return sendSuccessResponse("Marks updated successfully");
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllTestMarks() {
        LOGGER.info("request   - subject/findAll | findAllTestMarks");
        List<StudentSubjectDTO> all = subjectService.findAllTestMarks();
        LOGGER.info("response  - subject/findAll | findAllTestMarks | payload : {}", all);
        return sendSuccessResponse(all);
    }


}
