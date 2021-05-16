package com.example.ec.model;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 商品クラス。
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {

    /** 名前 */
    @NotNull
    private String name;

    /** 金額 */
    @NotNull
    @Min(1)
    private Long price;

    /** 画像 */
    @NotNull
    private byte[] image;

    /** 画像種別 */
    private String imageType;
}
