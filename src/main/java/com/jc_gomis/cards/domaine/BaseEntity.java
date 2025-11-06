package com.jc_gomis.cards.domaine;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Data
public class BaseEntity {

    @CreatedDate
    @Column(insertable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    LocalDateTime updatedAt;

    @CreatedBy
    @Column(insertable = false)
    String createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    String updatedBy;

}
