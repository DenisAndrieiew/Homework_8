package com.goIt.ProductManagement.model.service;

import com.goIt.ProductManagement.exeptions.UserAlreadyExistException;
import com.goIt.ProductManagement.model.dto.UserDTO;
import com.goIt.ProductManagement.model.entity.User;
import com.goIt.ProductManagement.model.enums.UserRole;
import com.goIt.ProductManagement.model.repository.RoleRepository;
import com.goIt.ProductManagement.model.repository.UserRepository;
import com.goIt.ProductManagement.model.service.converter.UserConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;
    private final UserConverter userConverter;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder,
                       UserConverter userConverter) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
        this.userConverter = userConverter;
    }

    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    public Set<UserDTO> findAllDTO() {
        return userConverter.toDTOSet(findAll());
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

    public UserDTO findById(UUID id) {
        return userConverter.toDTO(userRepository.getById(id));
    }

    public void update(UserDTO user) {
        userRepository.save(userConverter.fromDTO(user));
    }

    public void delete(UUID id) {
        userRepository.delete(userRepository.getById(id));
    }
}
