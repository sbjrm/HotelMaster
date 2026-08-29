package test.client;

import main.model.Client;
import main.repository.ClientRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static test.client.ClientData.defClient;

public class ClientRepositoryTest {
    private ClientRepository repo;

    @BeforeEach
    public void setup() {
        repo = ClientRepository.getInstance();
    }

    @Test
    @DisplayName("Должен успешно сохраниться пользователь")
    public void successSaveTest() {
        System.out.println("Save test");
        Client result = repo.save(defClient);
        System.out.println(result.getId());

        assertNotNull(result);
        assertNotEquals(0, result.getId());
    }

    @Test
    @DisplayName("Поиск по id")
    public void successFindById() {
        System.out.println("Find test");
        Client target = defClient;

        Client saved = repo.save(target);
        target.setId(saved.getId());
        Optional<Client> resultOptional = repo.findById(saved.getId());

        assertTrue(resultOptional.isPresent());
        Client result = repo.findById(saved.getId()).get();

        assertEquals(target, result);
    }

    @Test
    @DisplayName("Поиск по несуществующему id")
    public void notSuccessFindById() {
        int id = repo.save(defClient).getId() + 1;
        Optional<Client> resultOptional = repo.findById(id);

        assertFalse(resultOptional.isPresent());
    }

    @AfterEach
    public void tearDown() {

    }
}
