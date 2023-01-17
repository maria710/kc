package com.example.kc.controller;

import com.example.kc.dto.ContactMessageDTO;
import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.ContactMessage;
import com.example.kc.mapper.ContactMessageMapper;
import com.example.kc.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactUsController {

    private final ContactMessageMapper contactMessageMapper;
    private final ContactMessageService contactMessageService;


    @GetMapping(value = "/messages")
    public String getMessages(Model model) {
        List<ContactMessage> contactMessages = contactMessageService.getContactMessages();
        model.addAttribute("messages", contactMessages);
        return "messageList";
    }

    @GetMapping(value = "/addMessage")
    public String showForm(Model model) {
        model.addAttribute("formData", new ContactMessageDTO());
        return "contact";
    }

    @PostMapping(value = "/contactForm")
    public String addProduct(@ModelAttribute("formData") @Valid ContactMessageDTO contactMessageDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasFieldErrors()) {
            return "productForm";
        }
        var contactMessage = contactMessageService.addMessage(contactMessageDTO);
        if (contactMessage == null) {
            return "productForm";
        }
        model.addAttribute("message", contactMessageDTO.getMessage());
        model.addAttribute("firstName", contactMessageDTO.getFirstName());
        model.addAttribute("lastName", contactMessageDTO.getLastName());
        model.addAttribute("email", contactMessageDTO.getEmail());
        return "redirect:/";
    }

    @GetMapping(value = "/deleteMessage")
    public String deleteProduct(@ModelAttribute("id") Long id) {
        contactMessageMapper.toContactMessageDTO(contactMessageService.deleteMessage(id));
        return "redirect:/";
    }
}
