package com.app.service;

import com.app.dto.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO getUserById(Long id);

	UserDTO updateUser(Long id, UserDTO userDTO);

}
