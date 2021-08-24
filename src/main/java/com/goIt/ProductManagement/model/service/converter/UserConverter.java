package com.goIt.ProductManagement.model.service.converter;

import com.goIt.ProductManagement.model.dto.UserDTO;
import com.goIt.ProductManagement.model.entity.User;
import com.goIt.ProductManagement.model.repository.RoleRepository;
import com.goIt.ProductManagement.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO> {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserConverter(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setRole(user.getRole().getRole());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        return userDTO;
    }

    @Override
    public User fromDTO(UserDTO userDTO) {
        User user = userRepository.getById(userDTO.getId());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setRole(roleRepository.findByRole(userDTO.getRole()));
        return user;
    }
}
