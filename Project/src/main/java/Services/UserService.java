package Services;

import java.util.List;

import Dtos.AccountResponseDTO;
import Dtos.IbanResponseDTO;
import Dtos.TransactionResponseDTO;
import Dtos.UserResponseDto;
import Models.User;

public interface UserService {

    public List<UserResponseDto> getUsers();

    public UserResponseDto login(String username, String password);

    public boolean signup(User user);

    public IbanResponseDTO getUserIban(User user);

}
