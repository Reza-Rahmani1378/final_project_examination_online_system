package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Exam;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>, JpaSpecificationExecutor<Exam> {

    // get List of Exams of Specify Course With Id Of Course
    @EntityGraph(attributePaths = "course")
    List<Exam> getExamsByCourseId(Long id);


//    List<Exam>
}
