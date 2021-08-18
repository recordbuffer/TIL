package helloBoard.hellospringBoard.web;

import helloBoard.hellospringBoard.domain.posts.Posts;
import helloBoard.hellospringBoard.services.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
