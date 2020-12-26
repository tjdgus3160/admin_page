package kr.co.fastcampus.admin_page.repository;

import kr.co.fastcampus.admin_page.AdminPageApplicationTests;
import kr.co.fastcampus.admin_page.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends AdminPageApplicationTests {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        User user = new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
