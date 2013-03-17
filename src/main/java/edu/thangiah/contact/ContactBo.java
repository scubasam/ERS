package edu.thangiah.contact;

import java.util.List;

import edu.thangiah.contact.entity.Contact;
 
public interface ContactBo {
 
    void add(Contact contact);
 
    void update(Contact contact);
 
    void delete(Contact contact);
 
    List<Contact> findAll();
 
    List<Contact> findById(int id);
 
    List<Contact> findByUsername(String username);
}