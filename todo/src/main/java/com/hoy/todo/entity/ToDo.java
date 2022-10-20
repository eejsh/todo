package com.hoy.todo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//DB 컬럼값 설정
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)   // 경고에  warning: Generating equals/hashCode implementation but without a call to superclass, 추가해주면 경고 안뜸!
@Entity
@Table(name = "todo") //테이블 이름 생성
public class ToDo extends BaseEntity{
    //extends BaseEntity로 입력, 수정날짜 추가!
    
    //기본키로 사용할 ID
    //랜덤한 UUID를 가지고 ID값을 생성
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    // 사용자 식별을 위한 ID
    @Column(length = 100, nullable = false)
    private String userId;
    //userId =  대문자가 있으면 DB에 user_id로 저장됩니다.


    //제목
    @Column(length = 500, nullable = false)
    private String title;

    // 수행 여부
    @Column(nullable = false)
    private boolean done;

}
