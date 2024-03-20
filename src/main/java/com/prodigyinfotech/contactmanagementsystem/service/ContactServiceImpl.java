package com.prodigyinfotech.contactmanagementsystem.service;

import com.prodigyinfotech.contactmanagementsystem.dto.ContactDTO;
import com.prodigyinfotech.contactmanagementsystem.entity.Contact;
import com.prodigyinfotech.contactmanagementsystem.exception.ResourceNotFoundException;
import com.prodigyinfotech.contactmanagementsystem.respository.ContactRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements  ContactService{
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper){
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveContact(ContactDTO contactDTO){
        Contact contact = new Contact();
        modelMapper.map(contactDTO,contact); //map(dto obj, entity obj)
        contactRepository.save(contact);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                        .map(post->modelMapper.map(post,ContactDTO.class)) //using modelMapper() to convert entity to dto
                        .collect(Collectors.toList());
    }
    @Override
    public ContactDTO getContactById(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No contact found with the id: " + id)
        );
        return modelMapper.map(contact, ContactDTO.class);
    }
    @Override
    public ContactDTO updateContact( Long id,ContactDTO contactDTO) {
        Contact contact = contactRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("No contact found with the id: "+id)
        );

        if(!contactDTO.getName().isEmpty())
            contact.setName(contactDTO.getName());
        if(!contactDTO.getEmail().isEmpty())
            contact.setEmail(contactDTO.getEmail());
        if(!contactDTO.getPhoneNumber().isEmpty())
            contact.setPhoneNumber(contactDTO.getPhoneNumber());
        Contact updatedContact = contactRepository.save(contact);

        return modelMapper.map(updatedContact, ContactDTO.class);
    }
    @Override
    public void deleteContact(Long id) {
        contactRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("No contact found with the id: "+id)
        );
        contactRepository.deleteById(id);
    }
}