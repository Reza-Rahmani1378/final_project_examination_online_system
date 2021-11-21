package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.embeddable.QuestionOption;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import ir.maktab.examination_online_system.repositories.QuestionsRepository;
import ir.maktab.examination_online_system.services.QuestionsService;
import ir.maktab.examination_online_system.services.dto.QuestionsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class QuestionsServiceImpl extends BaseServiceImpl<Questions, Long, QuestionsRepository> implements QuestionsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionsServiceImpl.class);
    private static final String IN_SIDE_ = "Inside in saveNotSecure(Questions questions)";
    private static final String IN_SIDE_SAVE_ALL_NOT_SECURE = "Inside in saveAllNotSecure(Collection<Questions> collection) ";
    private static final String IN_SIDE_FIND_BY_ID_NOT_SECURE = "Inside in findByIdNotSecure(Long id)";
    private static final String IN_SIDE_FIND_ALL_NOT_SECURE = "Inside in findAllNotSecure()";
    private static final String IN_SIDE_FIND_ALL_NOT_SECURE_PAGEABLE = "Inside in findAllNotSecure(Pageable pageable)";
    private static final String IN_SIDE_DELETE_BY_ID_NOT_SECURE = "Inside in deleteByIdNotSecure(Long Id)";
    private static final String IN_SIDE_GET_QUESTIONS_BY_QUESTION_BANK_ID = "Inside in getQuestionsByQuestionBankId(Long Id)";
    private static final String IN_SIDE_FIND_ALL_BY_EXAM_ID = "Inside in findAllByExamId(Long examId)";
    private static final String IN_SIDE_SAVE_WITH_DEFAULT_SCORE = "Inside in saveWithDefaultScore(Questions questions, Exam exam)";

    @Autowired
    public QuestionsServiceImpl(QuestionsRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Questions saveNotSecure(Questions questions) {
        LOGGER.info(IN_SIDE_);
        return super.saveNotSecure(questions);
    }

    @Override
    public List<Questions> saveAllNotSecure(Collection<Questions> collection) {
        LOGGER.info(IN_SIDE_SAVE_ALL_NOT_SECURE);
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Questions> findByIdNotSecure(Long id) {
        LOGGER.info(IN_SIDE_FIND_BY_ID_NOT_SECURE);
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Questions> findAllNotSecure() {
        LOGGER.info(IN_SIDE_FIND_ALL_NOT_SECURE);
        return super.findAllNotSecure();
    }

    @Override
    public Page<Questions> findAllNotSecure(Pageable pageable) {
        LOGGER.info(IN_SIDE_FIND_ALL_NOT_SECURE_PAGEABLE);
        return super.findAllNotSecure(pageable);
    }

    @Override
    public void deleteByIdNotSecure(Long id) {
        LOGGER.info(IN_SIDE_DELETE_BY_ID_NOT_SECURE);
        try {
            super.deleteByIdNotSecure(id);
        } catch (AccessDeniedRunTimeException e) {
            throw new AccessDeniedRunTimeException(
                    "can't delete entity with id: " + id
            );
        }
    }

    @Override
    public List<Questions> getQuestionsByQuestionBankId(Long id) {
        LOGGER.info(IN_SIDE_GET_QUESTIONS_BY_QUESTION_BANK_ID);
        return repository.getQuestionsByQuestionBankId(id);
    }

    @Override
    public List<Questions> findAllByExamId(Long examId) {
        LOGGER.info(IN_SIDE_FIND_ALL_BY_EXAM_ID);
        return repository.findAllByExamId(examId);
    }

    @Override
    public Questions saveWithDefaultScore(Questions questions, Exam exam, QuestionScore<Long> questionScore) {
        LOGGER.info(IN_SIDE_SAVE_WITH_DEFAULT_SCORE);
        List<Exam> exams = new ArrayList<>();
        exams.add(exam);
        questions.setExams(exams);
//        QuestionScore<Long> questionScore = new QuestionScore<>();
//        questionScore.setExamId(exam.getId());
//        questionScore.setQuestionScore(20L);
        List<QuestionScore<Long>> questionScores = new ArrayList<>();
        questionScores.add(questionScore);
        questions.setQuestionScores(questionScores);
        return super.saveNotSecure(questions);
    }

    @Override
    public Questions editQuestions(Long questionsId, QuestionsDTO questionsDTO, Long questionScore, Long examId, QuestionType questionType, List<String> options) {
        Questions questions = repository.findById(questionsId).get();
        questions.setQuestionType(questionType);
        questions.setQuestionTitle(questionsDTO.getQuestionTitle());
        questions.setQuestionText(questionsDTO.getQuestionText());
        questions.getQuestionScores().removeIf(
                item -> Objects.equals(item.getExamId(), examId)
        );

        QuestionScore<Long> questionScore1 = new QuestionScore<>();
        questionScore1.setQuestionScore(questionScore);
        questionScore1.setExamId(examId);
        questions.getQuestionScores().add(questionScore1);
        if (questionType == QuestionType.DESCRIPTIVE) {
            questions.setQuestionAnswer(null);
            questions.getQuestionOptions().clear();
        } else {
            Set<QuestionOption> questionOptions = new HashSet<>();
            for (String option : options) {
                QuestionOption questionOption = QuestionOption.builder()
                        .optionText(option)
                        .build();
                questionOptions.add(questionOption);
            }
            questions.setQuestionOptions(questionOptions);
        }
        return repository.save(questions);


    }


}
