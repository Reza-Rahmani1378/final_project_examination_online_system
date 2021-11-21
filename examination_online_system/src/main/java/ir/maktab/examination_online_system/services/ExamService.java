package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Exam;

import java.util.List;

public interface ExamService extends BaseService<Exam, Long> {

    List<Exam> getExamsByCourseId(Long id);

}
