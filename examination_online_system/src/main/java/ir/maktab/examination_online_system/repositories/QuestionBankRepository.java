package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.QuestionBank;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long>, JpaSpecificationExecutor<QuestionBank> {

    @EntityGraph(attributePaths = {"course", "course.students", "course.professor", "course.admin"})
    QuestionBank getQuestionBankByCourseId(Long id);

}
