package com.prodigyinfotech.contactmanagementsystem.controller;

import com.prodigyinfotech.contactmanagementsystem.dto.ContactDTO;
import com.prodigyinfotech.contactmanagementsystem.service.ContactServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactServiceImpl contactService;
    public ContactController(ContactServiceImpl contactService){
        this.contactService = contactService;
    }
    @PostMapping
    public ResponseEntity<String> addContact( @RequestBody ContactDTO contactDTO) {
        contactService.saveContact(contactDTO);
        return new ResponseEntity<>("Contact stored successfully!", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> viewContacts() {
        List<ContactDTO> allContacts = contactService.getAllContacts();
        if(!allContacts.isEmpty()){
            return new ResponseEntity<>(allContacts,HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>("No contacts stored yet!", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        ContactDTO contactById = contactService.getContactById(id);
        return new ResponseEntity<>(contactById,HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable long id, @RequestBody ContactDTO contactDTO){
        ContactDTO dto = contactService.updateContact(id, contactDTO);
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
       return new ResponseEntity<>("Contact with id: "+id+" deleted successfully!",HttpStatus.ACCEPTED);
    }
}