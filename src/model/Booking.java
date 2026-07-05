package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private static int nextId = 1;

    private int id;
    private Client client;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int guestsCount;
    private double totalPrice;
    private String status;

    public Booking(Client client, Room room, LocalDate checkInDate, LocalDate checkOutDate, int guestsCount) {
        this.id = nextId++;
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestsCount = guestsCount;
        this.totalPrice = calculateTotalPrice();
        this.status = "Активно";
    }

    private double calculateTotalPrice() {
        long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return nights * room.getPricePerNight();
    }
}
