package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.AdminPageApplicationTests;
import kr.co.fastcampus.admin_page.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminPageApplicationTests {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");  // 폰 번호로 검색
        Assertions.assertNotNull(user);
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);    // 지정된 id가 이미 존재하면 해당 row에 대하여 update 수행
        });
    }

    @Test
    @Transactional  // db에서 쿼리 실행 후 rollback, 동작은 하나 실제 변경x
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);    // 지정된 id가 이미 존재하면 해당 row에 대하여 update 수행
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+deleteUser.get());
        }
        else {
            System.out.println("데이터 삭제 데이터 없음");
        }
    }
}
