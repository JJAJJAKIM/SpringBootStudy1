package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/h")
@CrossOrigin(origins = "*")
public class HtmlController {
	
	
	@GetMapping("/{html:[0-9]+}")
	public String menu1(@PathVariable(name = "html") int html, Model model) {
		
		List<String[]> list = new ArrayList<String[]>();
		String[] menu1 = new String[]{"bi1", "bi2", "bi3", "bi2", "bi3"};
		String[] menu2 = new String[]{"bi4", "bi5", "bi6"};
		String[] menu3 = new String[]{"bi7", "bi8"};
		String[] menu4 = new String[]{"bi9"};
		list.add(menu1);
		list.add(menu2);
		list.add(menu3);
		list.add(menu4);
		
		model.addAttribute("list", list.get(html));
		return "html/menu";
	}

}
