package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);   // ID로 역순하여 휴대폰 번호 첫번째 리턴 => 가장 마지막 매칭되는 번호 리턴

    // select * from user where account = ? << test03, test04
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    // select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);
}
