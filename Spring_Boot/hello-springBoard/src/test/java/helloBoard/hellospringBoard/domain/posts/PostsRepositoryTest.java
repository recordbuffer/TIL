package helloBoard.hellospringBoard.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)        //스프링부트와 Junit 사이 연결
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After                     //단위 테스트 끝날때마다 실행될 메소드
    public void cleanup(){
        postsRepository.deleteAll();    //테스트 끝나면 그 내용도 지워줌
    }

    @Test
    public void 게시글등록_불러오기테스트(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author("홍길동")
        .build());          //게시글 임의로 등록

        //when
        List<Posts> postsList = postsRepository.findAll();      //게시글 등록됐는지 불러오기

        //then                                     //given과 when 비교
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}