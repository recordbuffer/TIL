package helloBoard.hellospringBoard.web;

import helloBoard.hellospringBoard.services.posts.PostsService;
import helloBoard.hellospringBoard.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor    //Bean 주입 > @Autowired 대신 생성자로
@Controller
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/saveForm/post")   //요청이 들어오면
    public String save(@ModelAttribute PostsSaveRequestDto postForm){      //dto에 내용 담겨 넘어와
        postsService.save(postForm);   // postService의 save 메소드로 넘겨줌

        return "redirect:/";
    }
}
