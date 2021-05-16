package com.example.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * リポジトリ基底クラス。
 *
 * @param <T> Entity
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {

}
