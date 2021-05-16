package com.example.ec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.ec.security.Role;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 顧客クラス。
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Customer extends BaseEntity {

    /** UID */
    @NotNull
    @NotBlank
    private String uid;

    /** メールアドレス */
    @NotNull
    @NotBlank
    private String email;

    /** 名前 */
    @NotNull
    @NotBlank
    private String name;

    /** 権限 */
    @Enumerated
    private Role role = Role.ROLE_USER;

    /** カート商品リスト */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    /** カート商品リスト */
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        if (this.cartItems != null) {
            for (CartItem cartItem : cartItems) {
                cartItem.setCustomer(this);
            }
        }
    }

    /** カート商品リスト */
    public void addCartItems(CartItem cartItem) {
        this.cartItems.add(cartItem);
        cartItem.setCustomer(this);
    }
}
