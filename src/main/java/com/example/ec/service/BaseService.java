package com.example.ec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ec.model.BaseEntity;
import com.example.ec.repository.BaseMapper;
import com.example.ec.repository.BaseRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * サービス基底クラス。
 *
 * 参照系：MyBatis
 * 更新系：JPA
 *
 * @param <T> Entity
 */
@Service
@AllArgsConstructor
@Getter
public abstract class BaseService<T extends BaseEntity> {

    /** JpaRepository */
    private BaseRepository<T> repository;

    /** MyBatis Mapper */
    private BaseMapper<T> mapper;

    @Transactional
    public List<T> findAll() {
        return mapper.findAll();
    }

    @Transactional
    public Optional<T> findById(Long id) {
        return mapper.findById(id);
    }

    @Transactional
    public T save(T entity) {
        repository.saveAndFlush(entity);
        return findById(entity.getId()).orElse(null);
    }

    @Transactional
    public T update(T entity) {
        repository.saveAndFlush(entity);
        return findById(entity.getId()).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
