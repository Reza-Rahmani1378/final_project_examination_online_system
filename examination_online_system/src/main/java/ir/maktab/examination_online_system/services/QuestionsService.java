package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import ir.maktab.examination_online_system.services.dto.QuestionsDTO;
import ir.maktab.examination_online_system.services.dto.extra.QuestionDTOList;
import ir.maktab.examination_online_system.services.dto.extra.StudentAnswersDTO;

import java.util.List;
import java.util.Set;

public interface QuestionsService extends BaseService<Questions, Long> {

    Iterable<Questions> getQuestionsByQuestionBankId(Long id);

    Set<Questions> findAllByExamId(Long examId);

    Questions saveWithDefaultScore(Questions questions, Exam exam, QuestionScore<Long> questionScore);

    Questions editQuestions(Long questionsId,
                            QuestionsDTO questionsDTO,
                            Long questionScore,
                            Long examId,
                            QuestionType questionType,
                            List<String> options);

    Set<QuestionDTOList> getQuestionDTOList(Set<Questions> questions);

    void saveResult(List<StudentAnswersDTO> studentAnswersDTOS);

    Questions findByStudentResultExamsId(Long studentResultExamId);

    Questions findByQuestionsIdAndExamId(Long id, Long examId);

    void saveChangeScore(Long questionId, Long examId, Long grade);
}


