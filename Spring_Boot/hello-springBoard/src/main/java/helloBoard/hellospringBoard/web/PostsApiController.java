package helloBoard.hellospringBoard.web;

import helloBoard.hellospringBoard.services.posts.PostsService;
import helloBoard.hellospringBoard.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor    //Bean 주입 > @Autowired 대신 생성자로
@RestController
public class PostsApiController {

    private final PostsService postsService;

    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
