package service;

import exception.NotFoundException;
import model.Client;
import repository.ClientRepository;

import java.util.Optional;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public Client create(Client client) {
        System.out.println("Метод create в сервисе");
        return clientRepository.save(client);
    }

    public Client findById(int id) throws NotFoundException {
        //Optional<Client> found = clientRepository.findById(id);
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Клиент с id = " + id + " не найден"));

        /*if (found.isPresent()) {
            return found.get();
        } else {
            throw new NotFoundException("Клиент с id = " + id + " не найден");
        }*/
    }
}
