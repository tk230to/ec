package com.example.ec.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CartItem extends BaseEntity {

    /** 顧客 */
    @ManyToOne
    private Customer customer;

    /** 商品 */
    @ManyToOne
    private Item item;

    /** 数量 */
    private Long quantity;
}
