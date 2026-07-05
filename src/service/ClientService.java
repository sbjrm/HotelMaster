package service;

import model.Client;
import repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public Client create(Client client) {
        System.out.println("Метод create в сервисе");
        return clientRepository.save(client);
    }
}
