package helloBoard.hellospringBoard.services.posts;

import helloBoard.hellospringBoard.domain.posts.Posts;
import helloBoard.hellospringBoard.domain.posts.PostsRepository;
import helloBoard.hellospringBoard.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor    //Bean 주입 > @Autowired 대신 생성자로
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional      //메소드 실행시 트랜잭션 시작 ~ 정상종료되면 커밋 / 에러시 롤백
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public List<Posts> findPosts(){
        return postsRepository.findAll();
    }
}
