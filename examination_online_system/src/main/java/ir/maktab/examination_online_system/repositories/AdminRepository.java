package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.Admin;
import ir.maktab.examination_online_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>, JpaSpecificationExecutor<User> {


}
