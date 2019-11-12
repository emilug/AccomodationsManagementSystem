package com.sda.ams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sda.ams.model.Client;
import com.sda.ams.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("client", clients);
        return "client/list";
    }

    @GetMapping("/show/{clientId}")
    public String getById(Model model, @PathVariable Integer clientId) {
        Optional<Client> clientOptional = clientService.get(clientId);
        if (clientOptional.isPresent()) {
            model.addAttribute("client", clientOptional.get());
            return "client/show";
        } else {
            return "exceptions/404";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("client", new Client());
        return "client/create";
    }

    @GetMapping("/edit/{clientId}")
    public String edit(Model model, @PathVariable Integer clientId) {
        Optional<Client> clientOptional = clientService.get(clientId);
        if (clientOptional.isPresent()) {
            model.addAttribute("client", clientOptional.get());
            return "client/edit";
        } else {
            return "exceptions/404";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Client client, Model model) {
        client = clientService.save(client);
        model.addAttribute("client", client);
        return "client/show";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute Client client, Model model) {
        client = clientService.save(client);
        model.addAttribute("client", client);
        return "client/show";
    }

    @GetMapping("/delete/{clientId}")
    public String delete(@PathVariable Integer clientId) {
        clientService.delete(clientId);
        return "redirect:/client/list";
    }
}
