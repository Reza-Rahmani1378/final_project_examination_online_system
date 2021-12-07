package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.QuestionBank;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.services.dto.extra.QuestionDTOList;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>, JpaSpecificationExecutor<QuestionBank> {

    @EntityGraph(attributePaths = {"exams", "questionOptions"})
    Iterable<Questions> getQuestionsByQuestionBankId(Long id);


    @Query(value = "FROM Questions q inner join q.questionScores e where e.examId = ?1")
    Set<Questions> findAllByExamId(Long examId);

    @Query(value = "FROM Questions q inner join q.studentResultExams s where s.id = ?1")
    Questions findByStudentResultExamsId(Long studentResultExamId);

    @Query(value = "FROM Questions q inner join q.questionScores sc where q.id = ?1 and sc.examId = ?2")
    Questions findByQuestionsIdAndExamId(Long id, Long examId);


}
