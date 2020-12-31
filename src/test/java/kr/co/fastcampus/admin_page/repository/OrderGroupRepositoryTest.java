package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.AdminPageApplicationTests;
import kr.co.fastcampus.admin_page.model.entity.OrderGroup;
import kr.co.fastcampus.admin_page.model.enumclass.OrderGroupStatus;
import kr.co.fastcampus.admin_page.model.enumclass.OrderType;
import kr.co.fastcampus.admin_page.model.enumclass.PaymentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends AdminPageApplicationTests {

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){

        OrderGroup orderGroup = new OrderGroup();
        orderGroup.setStatus(OrderGroupStatus.COMPLETE);
        orderGroup.setOrderType(OrderType.ALL);
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType(PaymentType.CARD);
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");
        //orderGroup.setUserId(1L);

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assertions.assertNotNull(newOrderGroup);

    }
}
