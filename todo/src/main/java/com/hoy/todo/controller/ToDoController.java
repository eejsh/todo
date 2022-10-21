package com.hoy.todo.controller;

import com.hoy.todo.domain.ResponseDTO;
import com.hoy.todo.domain.ToDoDTO;
import com.hoy.todo.entity.ToDo;
import com.hoy.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("todo")
public class ToDoController {
    private final ToDoService toDoService;


    //http://localhost/todo에 Post방식으로 title만 설정
    //데이터 삽입
    @PostMapping
    public ResponseEntity<?> createToDo(@RequestBody ToDoDTO dto) {

        try {

            //가상의 userId 생성
            String temporaryUserId = "temporary-user";

            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            //데이터 생성
            List<ToDo> entities = toDoService.create(toDo);

            //ToDo를 ToDoDTO 로 변환
            //ToDoDTO의 생성자를 이용해서 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());

            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos)
                    .build();

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //ID로 조회
    @GetMapping
    public ResponseEntity<?> retriveToDoList() {

        String temporaryUserId = "temporary-user";

        List<ToDo> entites = toDoService.retrieve(temporaryUserId);

        //찾아온 데이터를 이용해서 DTO 의 List 만들기
        List<ToDoDTO> dtos =
                entites.stream().map(ToDoDTO::new).collect(Collectors.toList());

        //응답객체 생성
        ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().data(dtos).build();

        //클라이언트 전송
        return ResponseEntity.ok().body(response);

    }

    //데이터 수정
    //http://localhost/todo 에 put 방식으로 id, title, done 설정
    @PutMapping
    public ResponseEntity<?> updateToDo(@RequestBody ToDoDTO dto) {

        try {

            //가상의 userId 생성
            String temporaryUserId = "temporary-user";

            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            //데이터 생성
            List<ToDo> entities = toDoService.upadte(toDo);

            //ToDo를 ToDoDTO 로 변환
            //ToDoDTO의 생성자를 이용해서 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());

            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos)
                    .build();

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }

    }


    //데이터 삭제
    //http://localhost/todo
    @DeleteMapping
    public ResponseEntity<?> deleteToDo(@RequestBody ToDoDTO dto) {

        try {

            //가상의 userId 생성
            String temporaryUserId = "temporary-user";

            //Entity 생성
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            //데이터 생성
            List<ToDo> entities = toDoService.delete(toDo);

            //ToDo를 ToDoDTO 로 변환
            //ToDoDTO의 생성자를 이용해서 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());

            //응답객체 생성
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos)
                    .build();

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }

    }



}
