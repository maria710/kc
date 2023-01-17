package com.example.kc.service;

import com.example.kc.dto.ContactMessageDTO;
import com.example.kc.entity.ContactMessage;
import com.example.kc.mapper.ContactMessageMapper;
import com.example.kc.repository.ContactMessageRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ContactMessageService {

    private final ContactMessageMapper contactMessageMapper;
    private final ContactMessageRepository contactMessageRepository;

    public ContactMessage addMessage(ContactMessageDTO contactMessageDTO) {
        if (contactMessageDTO.getMessage().isEmpty()) {
            return null;
        }
        var message = contactMessageMapper.toContactMessage(contactMessageDTO);
        message.setActive(true);
        contactMessageRepository.save(message);
        return message;
    }

    public ContactMessage deleteMessage(Long id) {
        var message = contactMessageRepository.findById(id);
        message.ifPresent(m -> m.setActive(false));
        message.ifPresent(contactMessageRepository::save);
        return message.orElse(null);
    }

    public List<ContactMessage> getContactMessages() {
        return contactMessageRepository.findAll();
    }
}
