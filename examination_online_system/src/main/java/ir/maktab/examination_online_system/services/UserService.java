package ir.maktab.examination_online_system.services;

import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService<User, Long> {

    Optional<User> getUserByUsername(String username);

    List<User> getUsers(String keyword);

    String getUsername();

//    String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
}
