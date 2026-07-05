package repository;

import model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {
    private final Map<Integer, Client> clients;

    public ClientRepository() {
        this.clients = new HashMap<>();
    }

    public Client save (Client client) {
        System.out.println("метод save в репозитории");
        client.setId(getNextId());
        clients.put(client.getId(), client);
        System.out.println("Сохранили в хэшмап");
        return client;
    }

    private int getNextId() {
        return 1;
    }
}
