package ir.maktab.examination_online_system.repository;

import ir.maktab.examination_online_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
