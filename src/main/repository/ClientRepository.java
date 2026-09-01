package main.repository;

import main.model.Client;

import java.util.*;

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

    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }

    public Optional<Client> findByPhone(String phone) {
        return clients.values().stream()
                .filter(client -> phone.equals(client.getPhone()))
                .findFirst();
    }

    public Optional<Client> findByPassport(String passport) {
        return clients.values().stream()
                .filter(client -> passport.equals(client.getPassport()))
                .findFirst();
    }

    public Optional<Client> findByEmail(String email) {
        return clients.values().stream()
                .filter(client -> email.equals(client.getEmail()))
                .findFirst();
    }

    public Client updateById (int id, Client client) {
        client.setId(id);
        clients.put(id, client);
        return client;
    }

    public void deleteById (int id) {
        clients.remove(id);
    }

    private Integer getNextId() {
        int max = clients.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return ++max;
    }
}
