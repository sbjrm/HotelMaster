import model.Client;
import model.Room;
import service.ClientService;
import service.RoomService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static RoomService roomService = new RoomService();

    public static void main(String[] args) {
        System.out.println("Еще один commit");
        System.out.println("Еще один commit");
        System.out.println("Еще один commit");
        System.out.println("Еще один commit");

        ClientService clientService = new ClientService();
        Client client = new Client("Иван", "+6638942134", "passport", "ivan@gmail.com");
        System.out.println("Перед созданием " + client);
        client = clientService.create(client);
        System.out.println("После создания " + client);
        System.out.println("Конец теста");

        while (true) {
            printMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageRooms();
                    break;
                default:
                    System.out.println("Такая функция еще не реализована");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=============================");
        System.out.println("    СИСТЕМА УПРАВЛЕНИЯ ОТЕЛЕМ");
        System.out.println("=============================");
        System.out.println("1. Управление номерами");
        System.out.println("2. Управление клиентами");
        System.out.println("3. Управление бронированием");
        System.out.println("4. Поиск");
        System.out.println("5. Статистика");
        System.out.println("6. Выход");
        System.out.println("=============================");
    }

    private static void manageRooms() {
        while (true) {
            System.out.println("\n--- УПРАВЛЕНИЕ НОМЕРАМИ ---");
            System.out.println("1. Показать все номера");
            System.out.println("2. Добавить номер");
            System.out.println("...");
            System.out.println("0. Назад");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    roomService.printAllRooms();
                    break;
                case 2:
                    roomService.addRoom("11", "11", 2222);
                case 0:
                    return;
                default:
                    System.out.println("Такая функция еще не реализована");
            }
        }

    }
}
