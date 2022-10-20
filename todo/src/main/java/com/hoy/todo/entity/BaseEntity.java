package com.hoy.todo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//EntityListeners : Entity를 별도로 생성하지 않는 클래스
//MappedSuperclass : JPA를 감시하고 있다가 동작하도록 설정

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {

@CreatedDate  //생성날짜
@Column(name="regdate", updatable = false)
private LocalDateTime regDate;

@LastModifiedDate //마지막 수정날짜
@Column(name="moddate")
private LocalDateTime modDate;

}
