package az.academy.turing.usermanagementsystem.service;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import az.academy.turing.usermanagementsystem.dto.UserResponse;

import java.util.List;

public interface UsersService {
    void saveUsers(UserResponse userResponse);
    List<UserResponse>findAll();
    UserResponse findById(long id);
    UserResponse getUserByUserName(String name);
    void deleteById(Long id);
    void updateById(long id);

}
