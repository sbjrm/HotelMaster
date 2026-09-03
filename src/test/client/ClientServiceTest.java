package test.client;

import main.exception.NotFoundException;
import main.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static test.client.ClientData.defClient;
import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest {
    private ClientService service;

    @BeforeEach
    public void setUp() {
        service = new ClientService();
    }

    @Test
    @DisplayName("Поиск по несуществующему id должен выбрасывать NotFound")
    public void unknownIdShouldThrowNotFound() {
        int id = service.create(defClient).getId() + 1;

        assertThrows(
                NotFoundException.class,
                () -> service.findById(id)
        );
    }
}
