package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Professor;
import ir.maktab.examination_online_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>, JpaSpecificationExecutor<User> {


}
