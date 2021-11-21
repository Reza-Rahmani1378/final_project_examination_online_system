package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Professor;

public interface ProfessorService extends BaseService<Professor, Long> {

    Professor saveInfo(Professor professor);
}
