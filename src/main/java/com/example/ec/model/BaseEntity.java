package com.example.ec.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * Entity基底クラス。
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 作成日時 */
    @CreationTimestamp
    private ZonedDateTime createdAt;

    /** 作成者 */
    private String createdBy;

    /** 更新日時 */
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    /** 更新者 */
    private String updatedBy;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseEntity) {
            return getId() == ((BaseEntity) obj).getId();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
