package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.Student;
import ir.maktab.examination_online_system.repositories.StudentRepository;
import ir.maktab.examination_online_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, Long, StudentRepository> implements StudentService {


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
    }

    @Override
    public Student saveInfo(Student student) {
        return super.saveNotSecure(student);
    }

    @Override
    public Student saveNotSecure(Student student) {

        student.setPassword(NoOpPasswordEncoder.getInstance().encode(student.getPassword()));
        return super.saveNotSecure(student);
    }

    @Override
    public List<Student> saveAllNotSecure(Collection<Student> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Student> findByIdNotSecure(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAllNotSecure() {
        return null;
    }

    @Override
    public Page<Student> findAllNotSecure(Pageable pageable) {
        return super.findAllNotSecure(pageable);
    }

    @Override
    public void deleteByIdNotSecure(Long id) {

        throw new AccessDeniedRunTimeException(
                "can't delete entity with id: " + id
        );

    }
}
