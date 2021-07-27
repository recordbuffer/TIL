package helloBoard.hellospringBoard.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor      //기본생성자 자동 추가  == public Posts{}
@Getter             //getter 메소드 자동 추가
@Entity     //게시판 post에 관한 entity
public class Posts {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        //PK > auto increment

    @Column(length = 500, nullable = false)         //varchar(255)가 기본 > 500으로 늘려줌
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)    //varchar(255)가 기본 > type을 TEXT로 바꿔줌
    private String content;

    private String author;


    @Builder    //builder 클래스 자동 생성 > 생성자 대신 사용
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
