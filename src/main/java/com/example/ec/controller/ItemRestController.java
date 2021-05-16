package com.example.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.model.Item;
import com.example.ec.service.ItemService;

/**
 * 商品画面のコントローラクラス。
 */
@RestController
@RequestMapping("/api/open/items")
public class ItemRestController extends BaseRestController<Item> {

    @Autowired
    ItemService service;

    @Autowired
    public ItemRestController(ItemService service) {
        super(service);
    }
}
