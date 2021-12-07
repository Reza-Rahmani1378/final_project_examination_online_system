package ir.maktab.examination_online_system.restcontroller;

import ir.maktab.examination_online_system.models.StudentResultExam;
import ir.maktab.examination_online_system.services.StudentResultExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentResult")
public class StudentResultExamRestController {

    private final StudentResultExamService studentResultExamService;


    @Autowired
    public StudentResultExamRestController(StudentResultExamService studentResultExamService) {
        this.studentResultExamService = studentResultExamService;
    }


    // change grade of question that is specify form front and send id of studentResultExam
    @PostMapping(value = "/changeScore")
    public void changeScore(Long studentResultExamId, Long grade) {
        studentResultExamService.changeScore(studentResultExamId, grade);
    }
}
