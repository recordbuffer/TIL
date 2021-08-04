package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany     //실무에서는 사용 지양함
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    //계층구조 파악
    @ManyToOne(fetch = FetchType.LAZY)  //재귀
    @JoinColumn(name = "parent_id")
    private Category parent;    //부모

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();   //자식

    //연관관계 매소드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }
}
