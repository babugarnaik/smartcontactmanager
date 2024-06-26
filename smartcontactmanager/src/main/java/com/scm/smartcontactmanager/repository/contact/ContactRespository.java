package com.scm.smartcontactmanager.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.smartcontactmanager.entity.contact.Contact;

public interface ContactRespository<T> extends JpaRepository<Contact, Integer>{

}
