package ir.maktab.examination_online_system.base.web.rest;

import io.swagger.annotations.ApiOperation;
import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.base.BaseEntity;
import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.base.service.BaseService;
import ir.maktab.examination_online_system.exception.BadInputRunTimeException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseRestFul<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        S extends BaseService<E, PK>, M extends BaseMapper<E, D>> {

    private final S service;

    private final M mapper;

    public BaseRestFul(S service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @ApiOperation(value = "get all entity")
    public ResponseEntity<List<D>> getAll() {

        /*List<E> entityList = service.findAllNotSecure();
        List<D> dtoList = mapper.convertListEntityToDTO(entityList);
        return ResponseEntity.ok(dtoList);*/

        return ResponseEntity.ok(
                mapper.convertListEntityToDTO(
                        service.findAllNotSecure()
                )
        );
    }

    @GetMapping("/pageable")  /*  /user/pageable?size=5&page=1&sort=id,desc&sort=age,desc    */
    @ApiOperation(value = "get all entity")
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {

        Page<E> page = service.findAllNotSecure(pageable);

        /*return ResponseEntity.ok(
                page.map(
                        entity -> mapper.convertEntityToDTO(entity)
                )
        );*/

        return ResponseEntity.ok(
                page.map(
                        mapper::convertEntityToDTO
                )
        );

    }


    @GetMapping("/{id}") /* /user/5 */
    @ApiOperation(value = "find by id")
    public ResponseEntity<D> findById(@PathVariable("id") PK id) {
        Optional<E> optionalE = service.findByIdNotSecure(id);

        /*if (optionalE.isPresent()) {
            return ResponseEntity.ok(
                    mapper.convertEntityToDTO(
                            optionalE.get()
                    )
            );
        } else {
            return ResponseEntity.notFound().build();
        }*/

        /*return optionalE.map(e -> ResponseEntity.ok(
                mapper.convertEntityToDTO(
                        e
                )
        )).orElseGet(() -> ResponseEntity.notFound().build());*/

        return optionalE.map(e -> ResponseEntity.ok(
                mapper.convertEntityToDTO(
                        e
                )
        )).orElseThrow(() -> new BadInputRunTimeException("entity not found!!!"));

    }

    @DeleteMapping("/{id}") /* /user/5 */
    @ApiOperation(value = "delete by id")
    public ResponseEntity<Void> delete(@PathVariable("id") PK id) {
        service.deleteByIdNotSecure(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "save new entity", notes = "this is notes")
    public ResponseEntity<D> save(@RequestBody D d) {

        if (d.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        E entity = service.saveNotSecure(
                mapper.convertDTOToEntity(d)
        );

        return ResponseEntity.ok(
                mapper.convertEntityToDTO(entity)
        );

    }

    @PutMapping
    @ApiOperation(value = "update entity")
    public ResponseEntity<D> update(@RequestBody D d) {

        if (d.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        E entity = service.saveNotSecure(
                mapper.convertDTOToEntity(d)
        );

        return ResponseEntity.ok(
                mapper.convertEntityToDTO(entity)
        );

    }


}
