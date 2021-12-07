package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.User;
import ir.maktab.examination_online_system.repositories.UserRepository;
import ir.maktab.examination_online_system.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements
        UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public User saveNotSecure(User user) {
        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
        return super.saveNotSecure(user);
    }

    @Override
    @Transactional
    public List<User> saveAllNotSecure(Collection<User> collection) {
        return super.saveAllNotSecure(collection);
    }


    @Override
    public void deleteByIdNotSecure(Long id) {
        super.deleteByIdNotSecure(id);
        throw new AccessDeniedRunTimeException(
                "can't delete entity with id: " + id
        );
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }

    @Override
    public List<User> getUsers(String keyword) {
        if (keyword == null) {
            return super.repository.findAll();
        }
        return super.repository.finAll(keyword);
    }

    @Override
    public String getUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
