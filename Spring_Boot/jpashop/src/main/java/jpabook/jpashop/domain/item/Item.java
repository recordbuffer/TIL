package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //상속 관계이니 전략 선언해줘야함
@DiscriminatorColumn(name = "dtype")    //상속관계 매핑
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")     //실무에서는 사용 지양
    private List<Category> categories = new ArrayList<>();

    //비즈니스 로직
    //stockQuantity 가 item 엔티티에 존재하기 때문에
    // 이 핵심 stock 관리 로직은 여기 존재하는게 응집력 강함

    // stock 증가
    public void addstock(int quantity){
        this.stockQuantity += quantity;
    }

    //stock 감소
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock<0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
