package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserRepository;
import com.app.dto.UserDTO;
import com.app.pojos.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {

		User user = convertToEntity(userDTO);

		User savedUser = userRepository.save(user);

		return convertToDTO(savedUser);
	}

	@Override
	public UserDTO getUserById(Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		return convertToDTO(user);
	}
	
	@Override
	public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setName(userDTO.getName());
        existingUser.setAge(userDTO.getAge());
        existingUser.setAddress(userDTO.getAddress());
        existingUser.setContactNumber(userDTO.getContactNumber());

        User updatedUser = userRepository.save(existingUser);
        return convertToDTO(updatedUser);
    }

	private User convertToEntity(UserDTO userDTO) {

		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setAge(userDTO.getAge());
		user.setAddress(userDTO.getAddress());
		user.setContactNumber(userDTO.getContactNumber());

		return user;
	}

	private UserDTO convertToDTO(User user) {

		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setAge(user.getAge());
		userDTO.setAddress(user.getAddress());
		userDTO.setContactNumber(user.getContactNumber());

		return userDTO;

	}
}
