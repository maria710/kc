package com.example.kc.mapper;

import com.example.kc.dto.ContactMessageDTO;
import com.example.kc.entity.ContactMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactMessageMapper {
    public ContactMessage toContactMessage(ContactMessageDTO contactMessageDTO) {
        var contactMessage = new ContactMessage();
        contactMessage.setMessage(contactMessageDTO.getMessage());
        contactMessage.setEmail(contactMessageDTO.getEmail());
        contactMessage.setLastName(contactMessageDTO.getLastName());
        contactMessage.setFirstName(contactMessageDTO.getFirstName());

        return contactMessage;
    }

    public ContactMessageDTO toContactMessageDTO(ContactMessage contactMessage) {
        var contactMessageDTO = new ContactMessageDTO();
        contactMessageDTO.setMessage(contactMessage.getMessage());
        contactMessageDTO.setEmail(contactMessage.getEmail());
        contactMessageDTO.setLastName(contactMessage.getLastName());
        contactMessageDTO.setFirstName(contactMessage.getFirstName());

        return contactMessageDTO;
    }
}
