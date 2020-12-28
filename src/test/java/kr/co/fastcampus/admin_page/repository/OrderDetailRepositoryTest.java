package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.AdminPageApplicationTests;
import kr.co.fastcampus.admin_page.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminPageApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));    // 현재로 부터 2일 후
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");
        orderDetail.setOrderGroupId(1L);    // 어떠한 장바구니에
        orderDetail.setItemId(1L);          // 어떠한 상품

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }
}
