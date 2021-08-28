package helloBoard.hellospringBoard.web;

import helloBoard.hellospringBoard.domain.posts.Posts;
import helloBoard.hellospringBoard.services.posts.PostsService;
import helloBoard.hellospringBoard.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final PostsService postsService;

    @GetMapping("/board")
    public String board(Model model){
        List<Posts> posts = postsService.findPosts();
        model.addAttribute("posts",posts);
        return "board";
    }

    @GetMapping("/board/saveForm")
    public String savePosts(Model model){
        model.addAttribute("postForm", new PostsSaveRequestDto());
        return "postForm";
    }

    @PostMapping("/board/saveForm/new")
    public String boardSaveNewPost(PostsSaveRequestDto dto){
        return "/board";
    }
}
