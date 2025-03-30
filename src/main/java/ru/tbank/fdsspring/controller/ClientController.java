package ru.tbank.fdsspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tbank.fdsspring.entity.Client;
import ru.tbank.fdsspring.model.ClientsPage;
import ru.tbank.fdsspring.service.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
class ClientController {

    private final ClientService clientService;

    @GetMapping()
    public ClientsPage getAllUsers(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return clientService.getAllUsers(pageSize, pageNumber);
    }

    @PostMapping
    public Client createUser(@RequestBody Client user) {
        return clientService.createUser(user);
    }

    @GetMapping("/{id}")
    public Client getUserById(@PathVariable Long id) {
        return clientService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Client updateUser(@PathVariable Long id, @RequestBody Client userDetails) {
        return clientService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        clientService.deleteUser(id);
    }

    @PostMapping("/mail")
    public void sendMail() {
        clientService.sendMailToAllClients();
    }
}
