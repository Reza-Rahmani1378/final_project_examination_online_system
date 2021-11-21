package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.QuestionBank;

public interface QuestionBankService extends BaseService<QuestionBank, Long> {

    QuestionBank getQuestionBankByCourseId(Long id);
}
