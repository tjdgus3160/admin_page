package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.model.entity.Category;
import kr.co.fastcampus.admin_page.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Partner findByName(String name);

    List<Partner> findByCategory(Category category);
}
