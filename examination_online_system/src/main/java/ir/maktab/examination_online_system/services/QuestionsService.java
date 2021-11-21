package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import ir.maktab.examination_online_system.services.dto.QuestionsDTO;

import java.util.List;

public interface QuestionsService extends BaseService<Questions, Long> {

    List<Questions> getQuestionsByQuestionBankId(Long id);

    List<Questions> findAllByExamId(Long examId);

    Questions saveWithDefaultScore(Questions questions, Exam exam, QuestionScore<Long> questionScore);

    Questions editQuestions(Long questionsId,
                            QuestionsDTO questionsDTO,
                            Long questionScore,
                            Long examId,
                            QuestionType questionType,
                            List<String> options);
}
