package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.User;

import java.util.List;

public interface CourseService extends BaseService<Course, Long> {


    List<Course> getCourses(String keyword);

    List<Course> findCoursesByProfessorId(Long id);

    Iterable<Course> findCoursesByStudentId(Long studentId);

}
