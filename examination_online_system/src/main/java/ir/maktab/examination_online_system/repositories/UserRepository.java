package ir.maktab.examination_online_system.repositories;

import ir.maktab.examination_online_system.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> getUserByUsername(String username);

    // get Users with Native Query
    @EntityGraph(attributePaths = "userType")
    @Query("select u from User u where concat(u.firstName,' ', u.lastName, ' ', u.username, ' ', u.userType, ' ', u.email) LIKE %?1% AND u.userType != 'ADMIN'")
    List<User> finAll(String keyword);


    @EntityGraph(attributePaths = "userType")
    @Query("select u from User u where u.userType != 'ADMIN'")
    List<User> findAll();

    <P> P getUserByUsername(String username, Class<P> clazz);

}
