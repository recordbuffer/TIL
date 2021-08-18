package helloBoard.hellospringBoard.web;

import helloBoard.hellospringBoard.services.posts.PostsService;
import helloBoard.hellospringBoard.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor    //Bean 주입 > @Autowired 대신 생성자로
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")   //요청이 들어오면
    public Long save(@RequestBody PostsSaveRequestDto requestDto){      //dto에 내용 담겨 넘어와
        return postsService.save(requestDto);   // postService의 save 메소드로 넘겨줌
    }
}
