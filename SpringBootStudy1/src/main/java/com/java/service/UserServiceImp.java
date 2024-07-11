package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.dto.UserDTO;
import com.java.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
	
	private final UserMapper userMapper;
	
	public List<UserDTO> findList(String status) {
		return userMapper.findList(status);
	}
	
	public UserDTO findOne(UserDTO dto) {
		
		return userMapper.findOne(dto);
	}

	public int edit(UserDTO dto) {
		
		return userMapper.edit(dto);
	}

	public int save(UserDTO dto) {
		
		return userMapper.save(dto); 
	}

	public int status(UserDTO dto) {
		return userMapper.status(dto);
	}

}
