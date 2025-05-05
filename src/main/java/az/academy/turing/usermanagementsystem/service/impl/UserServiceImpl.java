package az.academy.turing.usermanagementsystem.service.impl;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import az.academy.turing.usermanagementsystem.domain.repository.UserRepository;
import az.academy.turing.usermanagementsystem.dto.UserRequest;
import az.academy.turing.usermanagementsystem.dto.UserResponse;
import az.academy.turing.usermanagementsystem.exception.ResourceNotFoundException;
import az.academy.turing.usermanagementsystem.mapper.UserMapper;
import az.academy.turing.usermanagementsystem.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserResponse> findAll() {
        List<Users> list = userRepository.findAll();
        return userMapper.toDtoList(list);
    }

    public void saveUsers(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("this email is already exist");
        }
        if (userRepository.existsByUsername(userRequest.getUsername())){
            throw new IllegalArgumentException("username is already taken");
        }
        Users users=new Users();
        users.setUsername(userRequest.getUsername());
        users.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        users.setEmail(userRequest.getEmail());
        users.setPhone_number(userRequest.getPhone_number());
        userMapper.toDto(userRepository.save(users));
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
    public UserResponse updateById(long id, UserRequest userRequest) {
        Users existingUser=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("user not found with id: "+id));
        existingUser.setUsername(userRequest.getUsername());
        existingUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPhone_number(userRequest.getPhone_number());

        Users updatedUser=userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }
}
