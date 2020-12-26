package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
