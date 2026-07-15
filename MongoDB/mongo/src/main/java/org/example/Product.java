package org.example;

import java.time.LocalDateTime;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @BsonId
    ObjectId id;
    String name;
    @BsonProperty("updated_at") //MongoDB에 저장되는 field 이름과 실제 Java 의 변수 이름이 다른 경우에 DB에서 사용하는 이름을 따로 명시
    LocalDateTime updatedAt;
    String contents;
    int price;
}