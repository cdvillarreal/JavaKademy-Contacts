package com.contacts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.interfaceServices.ContactInterfaceService;
import com.contacts.models.ContactModel;
import com.contacts.repositories.ContactRepository;

@Service
public class ContactService implements ContactInterfaceService{

	@Autowired
	private ContactRepository contactRepository;
	
	public ArrayList<ContactModel> getAllContacts() {
		return (ArrayList<ContactModel>) contactRepository.findAll();
	}
	
	public ContactModel saveContact(ContactModel contact) {
		return contactRepository.save(contact);
	}
	
	public Optional<ContactModel> getById(Integer id) {
		return contactRepository.findById(id);
	}
	
	public ArrayList<ContactModel> getByName(String name) {
		return contactRepository.findByName(name);
	}
	
	public boolean deleteContact(Integer id) {
		try {
			contactRepository.deleteById(id);
			return true;
		} catch(Exception error) {
			return false;
		}
	}
	
	@Override
	public List<ContactModel> listing() {
		return (List<ContactModel>)contactRepository.findAll();
	}

	@Override
	public Optional<ContactModel> listingId(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public int save(ContactModel c) {
		int res = 0;
		ContactModel contact = contactRepository.save(c);
		if(!contact.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		contactRepository.deleteById(id);
	}
}
