package com.contacts.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.models.ContactModel;
import com.contacts.services.ContactService;

@RestController
@RequestMapping("/api")
public class ContactRestController {

	@Autowired
	ContactService contactService;
	
	@GetMapping
	public ArrayList<ContactModel> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	@PostMapping()
	public ContactModel saveContact(@RequestBody ContactModel contact) {
		return this.contactService.saveContact(contact);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<ContactModel> getContactById(@PathVariable("id") Integer id) {
		return this.contactService.getById(id);
	}
	
	@GetMapping("/query")
	public ArrayList<ContactModel> getContactByName(@RequestParam("name") String name) {
		return this.contactService.getByName(name);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		boolean ok = this.contactService.deleteContact(id);
		if (ok) {
			return "Se eliminó correctamente el contacto con el id " + id;
		} else {
			return "No se pudo eliminar el contacto con el id " + id;
		}
	}
}
