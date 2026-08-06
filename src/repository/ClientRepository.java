package repository;

import model.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClientRepository {
    private final Map<Integer, Client> clients;

    private ClientRepository() {
        this.clients = new HashMap<>();
    }

    private static class Holder {
        private static final ClientRepository INSTANCE = new ClientRepository();
    }

    public static ClientRepository getInstance() {
        return Holder.INSTANCE;
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

    public Optional<Client> findByPhone(String phone) {
        return Optional.ofNullable(clients.get(phone));
    }

    public Optional<Client> findByPassport(String passport) {
        return Optional.ofNullable(clients.get(passport));
    }

    public Optional<Client> findByEmail(String email) {
        return Optional.ofNullable(clients.get(email));
    }

    private Integer getNextId() {
        int max = clients.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return ++max;
    }
}
