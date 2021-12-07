package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.repositories.CourseRepository;
import ir.maktab.examination_online_system.services.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepository> implements
        CourseService {

    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }

    @Override
    public Course saveNotSecure(Course course) {
        return super.saveNotSecure(course);
    }

    @Override
    public void deleteByIdNotSecure(Long id) {
        super.deleteByIdNotSecure(id);
        throw new AccessDeniedRunTimeException("can't delete this entity with id :" + id);
    }

    @Override
    public List<Course> getCourses(String keyword) {
        if (keyword == null) {
            return super.repository.findAll();
        }
        return super.repository.finAll(keyword);
    }

    @Override
    public List<Course> findCoursesByProfessorId(Long id) {
        return super.repository.findCoursesByProfessorId(id);
    }

    @Override
    public Iterable<Course> findCoursesByStudentId(Long studentId) {
        return repository.findCoursesByStudentId(studentId);
    }
}
