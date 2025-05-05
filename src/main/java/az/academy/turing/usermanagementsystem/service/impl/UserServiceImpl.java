package az.academy.turing.usermanagementsystem.service.impl;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import az.academy.turing.usermanagementsystem.domain.repository.UserRepository;
import az.academy.turing.usermanagementsystem.dto.UserResponse;
import az.academy.turing.usermanagementsystem.exception.ResourceNotFoundException;
import az.academy.turing.usermanagementsystem.mapper.UserMapper;
import az.academy.turing.usermanagementsystem.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> findAll() {
        List<Users> list = userRepository.findAll();
        return userMapper.toDtoList(list);
    }

    public void saveUsers(UserResponse userResponse) {

        Users users = userMapper.toEntity(userResponse);
        userRepository.save(users);
    }

    @Override
    public UserResponse findById(long id) {
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDto(users);

    }

    @Override
    public UserResponse getUserByUserName(String name) {
        Users users = userRepository.findByUsername(name)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with username: " + name));
        return userMapper.toDto(users);

    }

    @Override
    public void deleteById(Long id) {
        if (!(userRepository.existsById(id))) {
            throw new ResourceNotFoundException("user not found with id: " + id);
        } else {
            userRepository.deleteById(id);
        }
    }

    @Override
    public void updateById(long id) {

    }
}
