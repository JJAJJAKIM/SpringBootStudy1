package com.java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		int result =  userService.save(dto);
		if(result == 1) {			
			return "redirect:/u/detail?id="+ dto.getId();
		} else {
			return "redirect:/u/new";
		}
	}
	
	@GetMapping("/detail")
	public String detailpage(@ModelAttribute UserDTO dto, Model model) {
		dto = userService.findOne(dto);
		model.addAttribute("data", dto);
		return "/views/detail";
	}
	
	@GetMapping(value = {"/list", "/list/{status:[12]}"})
	public String listpage(@PathVariable(name = "status", required = false) String status, Model model) {
		List<UserDTO> list = userService.findList(status);
		model.addAttribute("list", list);
		return "/views/list";
	}
	
	@GetMapping("/edit")
	public String editpage(@ModelAttribute UserDTO dto){
		int result = userService.edit(dto);
		if(result == 1) {			
			return "redirect:/u/detail?id=" + dto.getId();
		} else {
			return "redirect:/u/new";
		}
	}
	
	@GetMapping("/status")
	public String editstatus(@ModelAttribute UserDTO dto) {
		int result = userService.status(dto);
		if(result == 1) {
			log.info("dto > {}", dto);
			return "redirect:/u/detail?id="+ dto.getId();			
		} else {
			return "redirect:/u/listtest";
		}
	}
	
	@GetMapping(value = {"/listtest", "/listtest/{status:[12]}"})
	public String listtest(@PathVariable(name = "status", required = false) String status, Model model) {
		List<UserDTO> list = userService.findList(status);
		model.addAttribute("list", list);
		return "/views/test1";
	}
	

	
}
