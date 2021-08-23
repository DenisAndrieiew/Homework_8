package com.goIt.ProductManagement.model.service;

import com.goIt.ProductManagement.exeptions.UserAlreadyExistException;
import com.goIt.ProductManagement.model.entity.User;
import com.goIt.ProductManagement.model.enums.UserRole;
import com.goIt.ProductManagement.model.repository.RoleRepository;
import com.goIt.ProductManagement.model.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository=roleRepository;
    }

    public void register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(String.format("User with specified email already exist %s", user.getEmail()));
        }
        user.setRole(roleRepository.findByRole(UserRole.ROLE_USER));
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(UUID.randomUUID());
        userRepository.save(user);
    }
}
