package com.query.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// JPA Entity들이 BaseTime을 상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)
// BaseTime 클래스에 Auditing 기능 포함
public class BaseTime {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
