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

    public Booking(Client client, Room room, LocalDate checkInDate, LocalDate checkOutDate, int guestsCount) {
        this.id = nextId++;
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestsCount = guestsCount;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return nights * room.getPricePerNight();
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getGuestsCount() {
        return guestsCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    /*public String getStatus() {
        return status;
    }*/

    public static void setNextId(int nextId) {
        Booking.nextId = nextId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setGuestsCount(int guestsCount) {
        this.guestsCount = guestsCount;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

   /* public void setStatus(String status) {
        this.status = status;
    }*/

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", client=" + client +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", guestsCount=" + guestsCount +
                ", totalPrice=" + totalPrice +
              //  ", status='" + status + '\'' +
                '}';
    }
}
