package com.hoy.todo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hoy.todo.entity.ToDo;
import com.hoy.todo.persistence.ToDoRepository;
import com.hoy.todo.service.ToDoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class ToDoTest {
    @Autowired
    private ToDoRepository toDoRepository;


    //데이터 삽입 테스트
    //@Test
    public void testInsert(){

        ToDo todo1 = ToDo.builder()
                .userId("hoy")
                .title("서점가기")
                .build();
        toDoRepository.save(todo1);

        ToDo todo2 = ToDo.builder()
                .userId("hoy")
                .title("점심먹기")
                .build();
        toDoRepository.save(todo2);


    }

    //유저 아이디를 이용한 조회
   // @Test
    public void testFindUserId(){

        List<ToDo> list =
                toDoRepository.findByUserId("hoy");

        for(ToDo toDo: list){
            System.out.println(toDo);
        }

        list.stream().forEach(toDo ->{
            System.out.println(toDo);
        });

    }



    //id에 해당하는 하나의 데이터 조회
    @Test
    @Disabled  //주석처리 하거나 disabled하면 test 처리 안됨.
    public void testDetail(){
        Optional<ToDo> result =
                toDoRepository.findById("4028e44c83f393bf0183f393c8540000");
        
        if(result.isPresent()){
            System.out.println(result.get());
            
        }else{
            System.out.println("데이터가 존재하지 않습니다. ");
        }
        
        
    }



    //데이터 수정
    //@Test
    public void testUpdate(){
        ToDo todo = ToDo.builder()
                .id("4028e44c83f393bf0183f393c8540000")
                .userId("hoy")
                .title("ㅎㅎ")
                .done(true)
                .build();
        toDoRepository.save(todo);

    }

    //delete id = deletebyid
    @Test
    @Disabled
    public void testDelete(){
       toDoRepository.deleteById("4028e44c83f393bf0183f393c8540000");
    }



    @Autowired
    private ToDoService toDoService;

    //삽입 테스트
    @Test
    @Disabled
    public void testServiceInsert(){
        ToDo toDo = ToDo.builder()
                .userId("hoy")
                .title("멍멍")
                .done(false)
                .build();

        List<ToDo> list = toDoService.create(toDo);
        System.out.println(list);

    }

    //출력 테스트
    //@Test
    public void testServiceRetrieve(){
        List<ToDo> list = toDoService.retrieve("hoy");
        System.out.println(list);

    }


    //수정 테스트
    //수정은 id값으로 설정했으므로 id값을 넣어주기.
    @Test
    @Disabled
    public void testServiceUpdate(){
        ToDo toDo = ToDo.builder()
                .id("4028e44c83f393bf0183f393c8af0001")
                .userId("hoy")
                .title("졸려어")
                .done(true)
                .build();

        List<ToDo> list = toDoService.upadte(toDo);
        System.out.println(list);
    }


    //데이터 삭제
    @Test
    @Disabled
    public void testServicedelete(){
        ToDo toDo = ToDo.builder()
                .id("4028e44c83f393bf0183f393c8af0001")
                .userId("hoy")
                .build();

        List<ToDo> list = toDoService.delete(toDo);
        System.out.println(list);
    }


}
