package ir.maktab.examination_online_system.services.impl;

import ir.maktab.examination_online_system.base.service.impl.BaseServiceImpl;
import ir.maktab.examination_online_system.exception.AccessDeniedRunTimeException;
import ir.maktab.examination_online_system.models.Professor;
import ir.maktab.examination_online_system.repositories.ProfessorRepository;
import ir.maktab.examination_online_system.services.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfessorServiceImpl extends BaseServiceImpl<Professor, Long, ProfessorRepository>
        implements ProfessorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorServiceImpl.class);
    private static final String IN_SIDE_SAVE_NOT_SECURE = "Inside in saveNotSecure(Professor professor)";
    private static final String IN_SIDE_SAVE_ALL_NOT_SECURE = "Inside in saveAllNotSecure(Collection<Professor> collection) ";
    private static final String IN_SIDE_FIND_BY_ID_NOT_SECURE = "Inside in findByIdNotSecure(Long id)";
    private static final String IN_SIDE_FIND_ALL_NOT_SECURE = "Inside in findAllNotSecure()";
    private static final String IN_SIDE_FIND_ALL_NOT_SECURE_PAGEABLE = "Inside in findAllNotSecure(Pageable pageable)";
    private static final String IN_SIDE_DELETE_BY_ID_NOT_SECURE = "Inside in deleteByIdNotSecure(Long Id)";

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        super(professorRepository);
    }


    @Override
    public Professor saveNotSecure(Professor professor) {
        LOGGER.info(IN_SIDE_SAVE_NOT_SECURE);
        professor.setPassword(NoOpPasswordEncoder.getInstance().encode(professor.getPassword()));
        return super.saveNotSecure(professor);
    }


    @Override
    public List<Professor> saveAllNotSecure(Collection<Professor> collection) {
        LOGGER.info(IN_SIDE_SAVE_ALL_NOT_SECURE);
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Professor> findByIdNotSecure(Long id) {
        LOGGER.info(IN_SIDE_FIND_BY_ID_NOT_SECURE);
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Professor> findAllNotSecure() {
        LOGGER.info(IN_SIDE_FIND_ALL_NOT_SECURE);
        return super.findAllNotSecure();
    }

    @Override
    public Page<Professor> findAllNotSecure(Pageable pageable) {
        LOGGER.info(IN_SIDE_FIND_ALL_NOT_SECURE_PAGEABLE);
        return super.findAllNotSecure(pageable);
    }

    @Override
    public void deleteByIdNotSecure(Long id) {
        LOGGER.info(IN_SIDE_DELETE_BY_ID_NOT_SECURE);
        try {
            super.deleteByIdNotSecure(id);
        } catch (AccessDeniedRunTimeException e) {
            throw new AccessDeniedRunTimeException(
                    "can't delete entity with id: " + id
            );
        }
    }

    @Override
    public Professor saveInfo(Professor professor) {
        return null;
    }
}
