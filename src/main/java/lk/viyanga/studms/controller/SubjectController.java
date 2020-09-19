package lk.viyanga.studms.controller;

import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.service.subject.SubjectService;
import lk.viyanga.studms.util.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@RestController
@RequestMapping("subject")
public class SubjectController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        LOGGER.info("request   - subject/findAll | findAll");
        List<SubjectDTO> all = subjectService.findAll();
        LOGGER.info("response  - subject/findAll | findAll | payload : {}", all);
        return sendSuccessResponse(all);
    }

}
