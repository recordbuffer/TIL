package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //1. 정적컨텐츠
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    }

    //2. MVC & 템플릿 엔진
    @GetMapping("hello-mvc")        //파라미터(name=?) 꼭 넘겨줘야 화면에 나옴
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //3. API
    //최근 가장 많이 쓰이는 방식
    //viewResolver 대신 HttpMessageConverter 동작함
    @GetMapping("hello-string")
    @ResponseBody               //Body부분에 직접 내용 넣어주겠다... view 필요없음
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")        //json방식으로 반환해 화면띄워줌
    @ResponseBody                //객체를 json으로 바꿔주는 라이브러리 : jackson (gson과 같은 역할 but 스프링은 기본이 jackson임)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    public class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
