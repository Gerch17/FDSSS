package ru.tbank.fdsspring.service;

import org.springframework.stereotype.Service;

@Service
public class MailService {

    public void sendMail(String client) {
        System.out.println("mail sent to: " + client);
    }

}
