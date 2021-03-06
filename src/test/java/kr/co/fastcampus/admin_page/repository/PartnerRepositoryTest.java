package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.AdminPageApplicationTests;
import kr.co.fastcampus.admin_page.model.entity.Partner;
import kr.co.fastcampus.admin_page.model.entity.User;
import kr.co.fastcampus.admin_page.model.enumclass.PartnerStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends AdminPageApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        String name = "Partner01";
        String statue = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(PartnerStatus.REGISTERED);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        //partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);

        Assertions.assertNotNull(newPartner);
        Assertions.assertEquals(newPartner.getName(),name);

    }

    @Test
    public void read(){

        String name = "Partner01";

        Partner partner = partnerRepository.findByName(name);  // 폰 번호로 검색
        Assertions.assertNotNull(partner);
    }
}
