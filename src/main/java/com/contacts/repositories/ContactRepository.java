package com.contacts.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contacts.models.ContactModel;

@Repository
public interface ContactRepository extends CrudRepository<ContactModel, Integer>{
	public abstract ArrayList<ContactModel> findByName(String name);
}
