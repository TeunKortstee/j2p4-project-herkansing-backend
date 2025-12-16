package Services;

import java.util.List;

import org.springframework.stereotype.Service;

import Dtos.AccountResponseDTO;
import Dtos.IbanResponseDTO;
import Dtos.TransactionResponseDTO;
import Dtos.UserResponseDto;
import Mappers.UserResponseDtoMapper;
import Models.User;
import Repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceJpa implements UserService {
    private final UserRepository userRepository;
    private final UserResponseDtoMapper mapper;

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(result -> this.mapper.userToResponseDtoMapper(result)).toList();
    }

    @Override
    public UserResponseDto login(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public boolean signup(User user) {
        user = this.userRepository.save(user);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public IbanResponseDTO getUserIban(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserIban'");
    }
}
