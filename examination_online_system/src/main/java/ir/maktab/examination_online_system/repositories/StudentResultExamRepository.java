package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.StudentResultExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentResultExamRepository extends JpaRepository<StudentResultExam, Long>, JpaSpecificationExecutor<StudentResultExam> {

    Set<StudentResultExam> findByStudentId(Long studentId);

}
