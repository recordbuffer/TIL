package jpabook.jpashop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)      //연관관계 > 1:M
    @JoinColumn(name = "member_id")         //매핑할 FK 이름 >> 연관관계 주인!
    private Member member;
                                    // order 저장하면 orderitem 같이 저장
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

                                    // order 저장하면 deliver 같이 저장
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)       //연관관계 > 1:1
    @JoinColumn(name = "delivery_id")       //연관관계의 주인
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문 상태 (ORDER, CANCEL)

    //연관관계 메서드
    //양방향 관계가 있는 엔터티끼리 편히 참조하기 위한 메서드
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //생성 메서드                                                        //...문법 : 여러개 넘길 수 있음
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems){
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for(OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);         //orderStatus 를 처음 ORDER로 강제함
        order.setOrderDate(LocalDateTime.now());
        return order;
    }


    //비지니스 로직
    //주문 취소
    public void cancel(){
        if(delivery.getStatus() == DeliveryStatus.CAMP){
            throw new IllegalStateException("이미 배송완료한 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL); //배송완료 아니면 주문 취소처리
        for(OrderItem orderItem : orderItems) {     //주문취소는 주문상품 별로 한번에 처리
            orderItem.cancel();
        }
    }

    //전체 주문 가격 조회
    public int getTotalPrice(){
        int totalPrice = 0;
        for(OrderItem orderItem : orderItems){
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
