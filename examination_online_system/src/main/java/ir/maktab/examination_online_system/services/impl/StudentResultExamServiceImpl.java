package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.Student;
import ir.maktab.examination_online_system.models.StudentResultExam;
import ir.maktab.examination_online_system.repositories.StudentResultExamRepository;
import ir.maktab.examination_online_system.services.StudentResultExamService;
import ir.maktab.examination_online_system.services.UserService;
import ir.maktab.examination_online_system.services.dto.extra.StudentAnswersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class StudentResultExamServiceImpl extends BaseServiceImpl<StudentResultExam, Long, StudentResultExamRepository>
        implements StudentResultExamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResultExamServiceImpl.class);
    private static final String IN_SIDE_SAVE_NOT_SECURE = "Inside in saveNotSecure(StudentResultExam studentResultExam)";
    private static final String IN_SIDE_SAVE_ALL_NOT_SECURE = "Inside in saveAllNotSecure(Collection<StudentResultExam> collection) ";
    private static final String IN_SIDE_FIND_BY_ID_NOT_SECURE = "Inside in findByIdNotSecure(Long id)";
    private static final String IN_SIDE_FIND_ALL_NOT_SECURE = "Inside in findAllNotSecure()";
    private static final String IN_SIDE_FIND_ALL_NOT_SECURE_PAGEABLE = "Inside in findAllNotSecure(Pageable pageable)";
    private static final String IN_SIDE_DELETE_BY_ID_NOT_SECURE = "Inside in deleteByIdNotSecure(Long Id)";

    private final UserService userService;

    @Autowired
    public StudentResultExamServiceImpl(StudentResultExamRepository studentResultExamRepository, UserService userService) {
        super(studentResultExamRepository);
        this.userService = userService;
    }


    @Override
    public StudentResultExam saveNotSecure(StudentResultExam studentResultExam) {
        LOGGER.info(IN_SIDE_SAVE_NOT_SECURE);
        return super.saveNotSecure(studentResultExam);
    }


    @Override
    public List<StudentResultExam> saveAllNotSecure(Collection<StudentResultExam> collection) {
        LOGGER.info(IN_SIDE_SAVE_ALL_NOT_SECURE);
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<StudentResultExam> findByIdNotSecure(Long id) {
        LOGGER.info(IN_SIDE_FIND_BY_ID_NOT_SECURE);
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<StudentResultExam> findAllNotSecure() {
        LOGGER.info(IN_SIDE_FIND_ALL_NOT_SECURE);
        return super.findAllNotSecure();
    }

    @Override
    public Page<StudentResultExam> findAllNotSecure(Pageable pageable) {
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
    public String checkIsAllowStudentForExam(Long studentId) {
        Set<StudentResultExam> studentResultExams = repository.findByStudentId(studentId);
        if (studentResultExams.size() != 0) {
            return "You have taken the test once";
        }
        return null;
    }

    @Override
    public StudentResultExam saveStudentAnswers(Questions questions, StudentAnswersDTO studentAnswersDTO) {
        Student student = (Student) userService.getUserByUsername(userService.getUsername()).get();
        StudentResultExam studentResultExam = new StudentResultExam();
        studentResultExam.setStudent(student);
        studentResultExam.setStudentAnswer(studentAnswersDTO.getAnswer());
        if (questions.getQuestionType().name().equals("OPTIONAL")) {
            if (questions.getQuestionAnswer().equals(studentAnswersDTO.getAnswer())) {
                studentResultExam.setStudentPoint(questions.getQuestionScores().get(0).getQuestionScore());
            } else {
                studentResultExam.setStudentPoint(0L);

            }
        }
        return saveNotSecure(studentResultExam);

    }

    @Override
    public void changeScore(Long studentResultExamId, Long score) {
        StudentResultExam studentResultExam = findByIdNotSecure(studentResultExamId).get();
        studentResultExam.setStudentPoint(score);
        saveNotSecure(studentResultExam);
    }
}
