package ir.maktab.examination_online_system.restcontroller;

import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.services.QuestionsService;
import ir.maktab.examination_online_system.services.dto.extra.QuestionDTOList;
import ir.maktab.examination_online_system.services.dto.extra.StudentAnswersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question-rest")
public class QuestionRestController {


    private final QuestionsService questionsService;


    @Autowired
    public QuestionRestController(
            QuestionsService questionsService
    ) {
        this.questionsService = questionsService;
    }

    // sent a list of dto questions to the front with @param examId

    @PostMapping("/get-questions")
    public Set<QuestionDTOList> getAllExamQuestions(Long idOfQuiz) {
        Set<Questions> questions = questionsService.findAllByExamId(idOfQuiz);
        return questionsService.getQuestionDTOList(questions);
    }


    // post answers form front to the rest controller
    @PostMapping(value = "/questions-result")
    public void questionsResult(@RequestBody List<StudentAnswersDTO> studentAnswersDTOS) {
        questionsService.saveResult(studentAnswersDTOS);
    }

    // change score of question with geting examId and questionId and grade form front
    @PostMapping(value = "/change-score")
    public void changeScoreQuestion(Long questionId, Long examId, Long grade) {
        questionsService.saveChangeScore(questionId, examId, grade);
    }


}
