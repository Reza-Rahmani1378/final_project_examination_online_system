package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.repositories.ExamRepository;
import ir.maktab.examination_online_system.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ExamServiceImpl extends BaseServiceImpl<Exam, Long, ExamRepository> implements ExamService {


    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        super(examRepository);
    }


    @Override
    @Transactional
    public Exam saveNotSecure(Exam exam) {

        return super.saveNotSecure(exam);
    }

    @Override
    public List<Exam> saveAllNotSecure(Collection<Exam> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Exam> findByIdNotSecure(Long id) {
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Exam> findAllNotSecure() {
        return super.findAllNotSecure();
    }

    @Override
    public Page<Exam> findAllNotSecure(Pageable pageable) {
        return super.findAllNotSecure(pageable);
    }

    @Override
    public void deleteByIdNotSecure(Long id) {

        try {
            super.deleteByIdNotSecure(id);
        } catch (AccessDeniedRunTimeException e) {
            throw new AccessDeniedRunTimeException(
                    "can't delete entity with id: " + id
            );
        }

    }

    @Override
    public List<Exam> getExamsByCourseId(Long id) {
        return super.repository.getExamsByCourseId(id);
    }

    @Override
    public List<Exam> findExamsByCourseId(Long id) {
        return repository.findExamsByCourseId(id);
    }
}
