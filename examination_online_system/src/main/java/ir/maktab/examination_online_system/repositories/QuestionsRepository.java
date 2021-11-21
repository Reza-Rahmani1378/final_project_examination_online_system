package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.QuestionBank;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>, JpaSpecificationExecutor<QuestionBank> {

    @EntityGraph(attributePaths = {"exams", "questionOptions"})
    List<Questions> getQuestionsByQuestionBankId(Long id);


    @Query(value = "FROM Questions q inner join q.questionScores e where e.examId = ?1")
    List<Questions> findAllByExamId(Long examId);


}
