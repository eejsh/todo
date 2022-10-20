package com.hoy.todo.persistence;


import com.hoy.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, String> {
                                    //JpaRepository Todo(java), todo에 있는 기본키속성 = id(string)를 기본키로 잡았음

    //userId를 가지고 조회하는 메서드
    //항상 리스트로 검색!
    public List<ToDo> findByUserId(String userId);



}
