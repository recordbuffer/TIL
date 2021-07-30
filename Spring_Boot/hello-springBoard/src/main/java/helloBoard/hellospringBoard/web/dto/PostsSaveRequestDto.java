package helloBoard.hellospringBoard.web.dto;

import helloBoard.hellospringBoard.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor      //기본생성자 자동 추가  == public Posts{}
@Getter             //getter 메소드 자동 추가
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder    //builder 클래스 자동 생성 > 생성자 대신 사용
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //Dto에서 필요한 부분을 entity화 시킴
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
