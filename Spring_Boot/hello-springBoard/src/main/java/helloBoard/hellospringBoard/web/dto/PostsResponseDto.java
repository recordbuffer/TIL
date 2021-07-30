package helloBoard.hellospringBoard.web.dto;

import helloBoard.hellospringBoard.domain.posts.Posts;
import lombok.Getter;

@Getter             //getter 메소드 자동 추가
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
