package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Student;

public interface StudentService extends BaseService<Student, Long> {

    Student saveInfo(Student student);
}
