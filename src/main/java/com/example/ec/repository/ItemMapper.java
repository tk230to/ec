package com.example.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.ec.model.Item;

/**
 * 商品Mapperクラス。
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

}
