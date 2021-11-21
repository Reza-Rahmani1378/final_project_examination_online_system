package ir.maktab.examination_online_system.base.service;

import ir.maktab.examination_online_system.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity<PK>, PK extends Serializable> {

    E saveNotSecure(E e);

    List<E> saveAllNotSecure(Collection<E> collection);

    Optional<E> findByIdNotSecure(PK id);

    List<E> findAllNotSecure();

    Page<E> findAllNotSecure(Pageable pageable);

    void deleteByIdNotSecure(PK id);

}
