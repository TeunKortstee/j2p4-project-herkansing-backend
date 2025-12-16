package Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Dtos.UserResponseDto;
import Models.User;

@Mapper
public interface UserResponseDtoMapper {
    UserResponseDtoMapper Instance = Mappers.getMapper(UserResponseDtoMapper.class);

    UserResponseDto userToResponseDtoMapper(User user);
}
