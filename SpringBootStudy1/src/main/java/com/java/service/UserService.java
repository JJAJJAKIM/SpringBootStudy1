package com.java.service;

import java.util.List;
import java.util.Optional;

import com.java.dto.UserDTO;

public interface UserService {
	
	public List<UserDTO> findList(String status);
	public UserDTO findOne(UserDTO dto);
	public int edit(UserDTO dto);
	public int save(UserDTO dto);
	public int status(UserDTO dto);
	
}
