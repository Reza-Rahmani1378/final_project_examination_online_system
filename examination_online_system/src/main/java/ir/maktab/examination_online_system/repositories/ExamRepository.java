package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Exam;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>, JpaSpecificationExecutor<Exam> {

    // get List of Exams of Specify Course With Id Of Course
    @EntityGraph(attributePaths = "course")
    List<Exam> getExamsByCourseId(Long id);

    //    @Query(value = "from Exam e inner join e.students s where s.isAllowedForExam = true ")
    List<Exam> findExamsByCourseId(Long id);


}
