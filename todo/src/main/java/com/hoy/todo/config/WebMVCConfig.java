package com.hoy.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// ------> 서버에서 cors 설정 해줘야함. @Configuration -> 인스턴스를 알아서 만듬 단, config~ 라고 써잇으면 프로젝트 전체에 적용됨.
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;



    @Override
    public void addCorsMappings(CorsRegistry registry) {

                 //허락할 요청
                registry.addMapping("/**")

                //허락할 클라이언트 URL을 등록    //나중엔 ip로 바뀜.
                .allowedOrigins("http://localhost:3000")

                //허락할 요청 방식 설정   //put횡전체수정, patch :횡 일부분 수정시 사용.
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")

                //허락할 헤더설정 .... 어떤 헤더가 올지  * ->모두
                        .allowedHeaders("*")
                //인증설정
                        .allowCredentials(true)

                //최대 접속 시간   -- 얼만큼 할지? 네트워크가 느릴때 무한대기상태, 일정시간 지나면 끊어줘야함.
                .maxAge(MAX_AGE_SECS);


    }

}
