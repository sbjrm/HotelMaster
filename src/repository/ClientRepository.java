package repository;

import model.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Optional<Client> findById(int id) {
        return Optional.ofNullable(clients.get(id));
    }

    private Integer getNextId() {
        int max = clients.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return ++max;
    }
}
