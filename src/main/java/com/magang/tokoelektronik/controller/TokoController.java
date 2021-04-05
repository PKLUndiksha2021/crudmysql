package com.magang.tokoelektronik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.magang.tokoelektronik.domain.Toko;
import com.magang.tokoelektronik.service.TokoService;

@Controller
public class TokoController {
	@Autowired
	private TokoService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Toko> listToko=service.listAll();
		model.addAttribute("listToko",listToko);
		System.out.print("Get/");
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("toko",new Toko());
		return "new";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveToko(@ModelAttribute("toko")Toko tk) {
		service.save(tk);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditTokoPage(@PathVariable(name="id")int id) {
		ModelAndView mav=new ModelAndView("new");
		Toko tk = service.get(id);
		mav.addObject("toko", tk);
		return mav;
		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteToko(@PathVariable(name="id")int id) {
		service.delete(id);
		return "redirect:/";
	}

}
