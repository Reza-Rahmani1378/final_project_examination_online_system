package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.StudentResultExam;
import ir.maktab.examination_online_system.services.dto.extra.StudentAnswersDTO;

public interface StudentResultExamService extends BaseService<StudentResultExam, Long> {

    String checkIsAllowStudentForExam(Long studentId);

    StudentResultExam saveStudentAnswers(Questions questions, StudentAnswersDTO studentAnswersDTO);

    void changeScore(Long studentResultExamId, Long score);
}
