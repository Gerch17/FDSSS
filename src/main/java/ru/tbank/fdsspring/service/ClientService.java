package ru.tbank.fdsspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.fdsspring.entity.Client;
import ru.tbank.fdsspring.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    public Client createUser(Client user) {
        return clientRepository.save(user);
    }

    public Client getUserById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Client updateUser(Long id, Client userDetails) {
        Client user = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return clientRepository.save(user);
    }

    public void deleteUser(Long id) {
        clientRepository.deleteById(id);
    }

}
