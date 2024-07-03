package com.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.UserDTO;
import com.java.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/u")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/new")
	public String newpage() {
		return "/views/new";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute UserDTO dto) {
		int no =  userService.save(dto);
		log.info("dto > {}", dto);
		return "redirect:/u/detail?id="+ dto.getId();
	}
	
	@GetMapping("/detail")
	public String detailpage(@ModelAttribute UserDTO dto, Model model) {
		dto = userService.findOne(dto);
		
		model.addAttribute("data", dto);
		return "/views/detail";
	}
	
	@GetMapping("/list")
	public String listpage(Model model) {
		List<UserDTO> list = userService.findList();
		log.info("list > {}", list);
		model.addAttribute("list", list);
		return "/views/list";
	}
}