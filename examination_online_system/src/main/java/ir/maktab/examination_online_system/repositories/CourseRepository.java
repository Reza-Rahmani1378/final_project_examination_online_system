package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {


    @EntityGraph(attributePaths = "titleCourse")
    @Query("select c from Course c where c.titleCourse LIKE %?1%")
    List<Course> finAll(String keyword);

    @EntityGraph(attributePaths = "titleCourse")
    List<Course> findAll();

    @EntityGraph(attributePaths = "professor")
    List<Course> findCoursesByProfessorId(Long id);

    @EntityGraph(attributePaths = "students")
    @Query(value = "from Course c join c.students s where s.id = ?1")
    Iterable<Course> findCoursesByStudentId(Long studentId);


}
