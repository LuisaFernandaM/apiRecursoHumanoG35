package com.reto3.demo.service;


import java.util.List;
import java.util.Optional;
import com.reto3.demo.model.Message;
import com.reto3.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message msg) {
        if (msg.getIdMessage() == null) {
            return messageRepository.save(msg);
        } else {
            Optional<Message> consulta = messageRepository.getMessage(msg.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepository.save(msg);
            } else {
                return msg;

            }
        }
    }

}
