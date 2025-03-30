package ru.tbank.fdsspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tbank.fdsspring.entity.Client;
import ru.tbank.fdsspring.model.ClientsPage;
import ru.tbank.fdsspring.repository.ClientRepository;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final MailService mailService;

    @Transactional(readOnly = true)
    public ClientsPage getAllUsers(int pageSize, int pageNumber) {
        long clientAmount = clientRepository.count();


        clientRepository.findClientsPage(pageSize, pageNumber*pageSize);


        List<Client> clients = clientRepository.findClientsPage(pageSize, pageNumber*pageSize);
        return ClientsPage.builder()
                .clients(clients)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .pageAmount((int)clientAmount/pageSize)
                .build();
    }

    @Transactional(readOnly = true)
    public void sendMailToAllClients() {
        try (Stream<Client> clients = clientRepository.findAllClients()) {
            clients.forEach(client -> mailService.sendMail(client.getEmail()));
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public List<Client> getUsersByName() {
        return clientRepository.findClientsByName("Игорь");
    }

    @Transactional
    public Client createUser(Client user) {
        return clientRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Client getUserById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public Client updateUser(Long id, Client userDetails) {
        Client user = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return clientRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        clientRepository.deleteById(id);
    }

}
