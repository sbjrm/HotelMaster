package service;

import exception.NotFoundException;
import model.Client;
import repository.ClientRepository;

import java.util.Map;
import java.util.Optional;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = ClientRepository.getInstance();
    }

    public Client create(Client client) {
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

    public Client findByPhone(String phone) throws NotFoundException {
        Optional<Client> found = clientRepository.findByPhone(phone);
        return  clientRepository
                .findByPhone(phone)
                .orElseThrow(() -> new NotFoundException("Клиент с телефоном = " + phone + " не найден"));
    }

    public Client findByPassport(String passport) throws NotFoundException {
        Optional<Client> found = clientRepository.findByPassport(passport);
        return clientRepository
                .findByPassport(passport)
                .orElseThrow(() -> new NotFoundException("Клиент с пасспортом = " + passport + " не найден"));
    }

    public Client findByEmail(String email) throws NotFoundException {
        Optional<Client> found = clientRepository.findByEmail(email);
        return clientRepository
                .findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Клиент с эмейлом = " + email + " не найден"));
    }

    public Client updateById(int id, Client client) throws NotFoundException {
        findById(id);
        return clientRepository
                .updateById(id, client);
    }

    public boolean deleteById (int id) throws NotFoundException{
        findById(id);
        clientRepository.deleteById(id);
        return clientRepository
                .findById(id)
                .isEmpty();
    }
}
