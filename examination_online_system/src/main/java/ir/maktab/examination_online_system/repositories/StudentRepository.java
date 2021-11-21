package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.Student;
import ir.maktab.examination_online_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<User> {


}
