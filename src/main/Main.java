package main;

import main.exception.NotFoundException;
import main.model.Booking;
import main.model.Client;
import main.model.Room;
import main.service.BookingService;
import main.service.ClientService;
import main.service.RoomService;

import java.time.LocalDate;
import java.util.Scanner;


//#TODO Реализовать методы create и findById в RoomRepository, метод по генерации id
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static RoomService roomService = new RoomService();
    static ClientService clientService = new ClientService();
    static BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        tests();
        testBooking();
        testPhone();
    }

    public static void testPhone() {
        Client client1 = new Client("Первый", "+6638942134", "passport", "ivan@gmail.com");
        Client client2 = new Client("Второй", "+6638942164", "passport", "ivan@gmail.com");

        clientService.create(client1);
        clientService.create(client2);

        try {
            System.out.println("Первый:");
            System.out.println(clientService.findByPhone("+6638942134"));
            System.out.println("Второй:");
            System.out.println(clientService.findByPhone("+6638942164"));
            System.out.println("Такого нет ");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }

    public static void testBooking() {
        try {
            Client client = new Client("Иван", "+6638942134", "passport", "ivan@gmail.com");
            client = clientService.create(client);
            Room room = new Room("10", "Двухместная", 5000);
            room = roomService.create(room);
            Booking booking = new Booking(client,
                    room,
                    LocalDate.of(2026, 10, 22),
                    LocalDate.of(2026, 10, 24),
                    2);
            booking = bookingService.create(booking);
            System.out.println(booking);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void tests() {
        try {
            Client client = new Client("Иван", "+6638942134", "passport", "ivan@gmail.com");
            System.out.println("Перед созданием " + client);
            client = clientService.create(client);
            System.out.println("После создания " + client);
            System.out.println("Конец теста");

            System.out.println("Поиск по id: 1");
            Client found = clientService.findById(1);

            System.out.println(found);
            System.out.println();

            System.out.println("Поиск по id: 2");
            found = clientService.findById(2);

            System.out.println(found);
        } catch (NotFoundException e) {
            System.out.println("Not found: " + e.getMessage());
        }

       /* while (true) {
            printMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageRooms();
                    break;
                default:
                    System.out.println("Такая функция еще не реализована");
            }
        }*/
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
                   // roomService.addRoom("11", "11", 2222);
                case 0:
                    return;
                default:
                    System.out.println("Такая функция еще не реализована");
            }
        }

    }
}
