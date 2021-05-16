package com.example.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.model.Item;
import com.example.ec.repository.ItemMapper;
import com.example.ec.repository.ItemRepository;

import lombok.Getter;

@Service
@Getter
public class ItemService extends BaseService<Item> {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ItemMapper mapper;

    @Autowired
    public ItemService(ItemRepository repository, ItemMapper mapper) {
        super(repository, mapper);
    }
}
