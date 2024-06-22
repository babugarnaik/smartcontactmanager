package com.scm.smartcontactmanager.repository.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.contact.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	public Contact findByFirstName(String name);
	
	@Query("select c from Contact c where Lower(c.firstName) Like Lower(concat('%', :name, '%'))")
	public List<Contact> searchByName(@Param("name")String name, Pageable page);
	public Contact findByPersonalEmail(String email);
	public Contact findByContactNumber(String number);
	public Contact findByWorkEmail(String workemail);
	public Contact findByFirstNameAndMiddleNameAndLastName(String firstName,String middleName,String lastName);
	
}
