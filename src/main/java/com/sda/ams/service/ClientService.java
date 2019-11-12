package com.sda.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.ams.model.Client;
import com.sda.ams.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> get(Integer id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Integer id) {
        Optional<Client> optionalClient = get(id);
        if (optionalClient.isPresent()) {
            clientRepository.delete(optionalClient.get());
        }
    }
}
