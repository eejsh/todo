package com.hoy.todo.domain;

import com.hoy.todo.entity.ToDo;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoDTO {

    private String id;
    private String title;
    private boolean done;


    //Entity를 받아서 DTO 인스턴스를 생성해주는 생성자
    public ToDoDTO(final ToDo toDo){
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
    }

    //DTO 인스턴스를 Entity 인스턴스로 변화해 주는 메서드 (service에 안만들고 DTO에~)


    public static ToDo toEntity(final ToDoDTO dto){
        return ToDo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();

    }


}
