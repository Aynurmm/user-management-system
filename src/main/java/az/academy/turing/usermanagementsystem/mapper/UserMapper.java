package az.academy.turing.usermanagementsystem.mapper;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import az.academy.turing.usermanagementsystem.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<Users, UserResponse> {

    @Override
    Users toEntity(UserResponse userResponse);

    @Override
    List<Users> toEntity(List<UserResponse> userResponseList);

    @Override
    UserResponse toDto(Users user);

    @Override
    List<UserResponse> toDtoList(List<Users> usersList);
}

