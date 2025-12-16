package Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dtos.AccountResponseDTO;
import Dtos.IbanResponseDTO;
import Dtos.LoginRequestDTO;
import Dtos.SignupRequestDTO;
import Dtos.TransactionResponseDTO;
import Dtos.UserResponseDto;
import Models.User;
import Services.AccountService;
import Services.TransactionService;
import Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TransactionService transactionService;
    private final AccountService accountService;

    public ResponseEntity<?> getUsers() {
        List<UserResponseDto> users = this.userService.getUsers();
        return ResponseEntity.ok(users);
    }

    public UserResponseDto login(@RequestBody LoginRequestDTO loginRequest) {
        // TODO implement login method with JWT security
        return this.userService.login(loginRequest.email, loginRequest.password);
    }

    public boolean signup(@RequestBody SignupRequestDTO signupRequest) {
        User user = User.builder().firstname(signupRequest.firstName).lastname(signupRequest.lastName)
                .email(signupRequest.email).BSN(signupRequest.BSN).password(signupRequest.password).build();
        return this.userService.signup(user);
    }

    public IbanResponseDTO getUserIban(@RequestBody SignupRequestDTO signupRequest) {
        User user = User.builder().firstname(signupRequest.firstName).lastname(signupRequest.lastName)
                .email(signupRequest.email).BSN(signupRequest.BSN).password(signupRequest.password).build();
        return this.userService.getUserIban(user);
    }

    public List<AccountResponseDTO> getUserAccounts(@RequestBody SignupRequestDTO signupRequest) {
        User user = User.builder().firstname(signupRequest.firstName).lastname(signupRequest.lastName)
                .email(signupRequest.email).BSN(signupRequest.BSN).password(signupRequest.password).build();
        return this.accountService.getUserAccounts(user);
    }

    public List<TransactionResponseDTO> getUserTransactions(@RequestBody SignupRequestDTO signupRequest) {
        User user = User.builder().firstname(signupRequest.firstName).lastname(signupRequest.lastName)
                .email(signupRequest.email).BSN(signupRequest.BSN).password(signupRequest.password).build();
        return this.transactionService.getUserTransactions(user);
    }
}
