package com.example.ec.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.model.BaseEntity;
import com.example.ec.service.BaseService;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 基底コントローラクラス。
 */
@RestController
@AllArgsConstructor
@Getter
public abstract class BaseRestController<T extends BaseEntity> {

    protected BaseService<T> service;

    /**
     * 全件表示。
     *
     * @return Entity
     */
    @GetMapping
    public ResponseEntity<List<T>> get() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * 1件表示。
     *
     * @param id EntityID
     * @return Entity
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<T> getOne(@PathVariable("id") Long id) {

        T entity = getService().findById(id).orElse(null);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    /**
     * 登録。
     *
     * @param Entity画面入力値
     * @return Entity
     * @throws IOException
     */
    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T entity) {
        entity = getService().save(entity);
        return ResponseEntity.ok(entity);
    }

    /**
     * 更新。
     *
     * @param Entity画面入力値
     * @return Entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<T> update(@PathVariable("id") Long id, @Validated @RequestBody T entity) {
        entity = getService().save(entity);
        return ResponseEntity.ok(entity);
    }

    /**
     * 削除。
     *
     * @param id EntityID
     * @return 204:No Content
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> list(@PathVariable("id") Long id) {
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
