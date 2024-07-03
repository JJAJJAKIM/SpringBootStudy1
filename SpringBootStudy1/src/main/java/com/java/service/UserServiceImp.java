package com.java.service;

import java.util.List;

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
	
	public List<UserDTO> findList() {
		return userMapper.findList();
	}
	
	public UserDTO findOne(UserDTO dto) {
		
		return userMapper.findOne(dto);
	}

	public UserDTO edit(UserDTO dto) {
		userMapper.edit(dto);
		return dto;
	}

	public int save(UserDTO dto) {
		
		return userMapper.save(dto); 
	}

	public UserDTO accept(UserDTO dto) {
		userMapper.accept(dto);
		return dto;
	}

}
