package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        //엔터티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());


        //주문상품 생성   > 비즈니스 로직통해 쉽게 실행  "도메인 모델 패턴"
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문생성  > 비즈니스 로직통해 쉽게 실행
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문저장
        orderRepository.save(order);        //주문 save 하나 해도 casecade 옵션 ALL 통해
                                            //orderItem, delivery가 자동 save 됨
        return order.getId();
    }


    //취소
    @Transactional
    public void cancelOrder(Long orderId){
        //주문 엔터티 조회
        Order order = orderRepository.findOne(orderId);

        //주문 취소 > 비즈니스 로직통해 쉽게 실행
        order.cancel();
    }


    //검색
    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAll(orderSearch);
    }
}
