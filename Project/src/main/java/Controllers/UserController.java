package Controllers;

import org.springframework.web.bind.annotation.RestController;

import Models.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
    private User user() {
        return User.builder()
                .email("teunKortstee@gmail.com")
                .password("TestTest123!")
                .build();
    }
}
