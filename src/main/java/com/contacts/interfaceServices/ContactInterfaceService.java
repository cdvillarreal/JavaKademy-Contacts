package com.contacts.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.contacts.models.ContactModel;

public interface ContactInterfaceService {
	public List<ContactModel>listing();
	public Optional<ContactModel>listingId(int id);
	public int save(ContactModel c);
	public void delete(int id);
}
