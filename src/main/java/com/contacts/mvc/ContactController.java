package com.contacts.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.interfaceServices.ContactInterfaceService;
import com.contacts.models.ContactModel;

@Controller
@RequestMapping
public class ContactController {
	
	@Autowired
	private ContactInterfaceService service;
	
	@GetMapping("/")
	public String listing(Model model) {
		List<ContactModel>contacts=service.listing();
		model.addAttribute("contacts", contacts);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String add(Model model) {
		model.addAttribute("contact", new ContactModel());
		return "form";
	}
	
	@PostMapping("/guardar")
	public String save(@Validated ContactModel c, Model model) {
		service.save(c);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<ContactModel>contact=service.listingId(id);
		model.addAttribute("contact", contact);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/";
	}
}
