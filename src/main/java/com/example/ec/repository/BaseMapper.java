package com.example.ec.repository;

import java.util.List;
import java.util.Optional;

/**
 * Mapper基底クラス。
 *
 * @param <T> Entity
 */
public interface BaseMapper<T> {

    /**
     * 全件取得。
     * @return 全レコード
     */
    List<T> findAll();

    /**
     * 1件取得。
     * @param id ID
     * @return 1レコード
     */
    Optional<T> findById(Long id);
}
