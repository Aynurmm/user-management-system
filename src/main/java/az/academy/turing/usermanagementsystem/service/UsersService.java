package az.academy.turing.usermanagementsystem.service;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import az.academy.turing.usermanagementsystem.dto.UserRequest;
import az.academy.turing.usermanagementsystem.dto.UserResponse;

import java.util.List;

public interface UsersService {
    void saveUsers(UserRequest userRequest);
    List<UserResponse>findAll();
    UserResponse findById(long id);
    UserResponse getUserByUserName(String name);
    void deleteById(Long id);
    UserResponse updateById(long id, UserRequest userRequest);

}
