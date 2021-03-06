package com.example.ec.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.ec.model.Customer;

/**
 * 顧客リポジトリクラス。
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    Optional<Customer> findByUid(String uid);
}
