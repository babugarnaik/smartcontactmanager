package com.scm.smartcontactmanager.repository.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.contact.Contact;

@Repository
public interface ContactRespository extends JpaRepository<Contact, Integer>{
	
	List<Contact> findByIdIn(List<Integer> contactIds);
	
 
}
