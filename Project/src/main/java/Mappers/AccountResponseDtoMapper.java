package Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Dtos.AccountResponseDTO;
import Models.Account;

@Mapper
public interface AccountResponseDtoMapper {
    AccountResponseDtoMapper Instance = Mappers.getMapper(AccountResponseDtoMapper.class);

    AccountResponseDTO accountToAccountResponseDTO(Account account);
}
