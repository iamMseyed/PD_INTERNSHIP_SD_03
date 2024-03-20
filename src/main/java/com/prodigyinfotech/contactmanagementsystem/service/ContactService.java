package com.prodigyinfotech.contactmanagementsystem.service;

import com.prodigyinfotech.contactmanagementsystem.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    ContactDTO saveContact(ContactDTO contactDTO);
    List<ContactDTO> getAllContacts();
    ContactDTO getContactById(Long id);
    ContactDTO updateContact(Long id,ContactDTO contactDTO);
    void deleteContact(Long id);
}