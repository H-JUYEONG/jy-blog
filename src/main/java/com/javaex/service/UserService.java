package com.javaex.service;

import com.javaex.entity.User;
import com.javaex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        // 중복 체크
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("이미 존재하는 사용자명입니다.");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}