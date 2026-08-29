package main.model;

import java.util.Objects;

public class Room {
    private int id;
    private String roomNumber;
    private String type;
    private String status;
    private double pricePerNight;

    public Room(String roomNumber, String type, double priceNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = priceNight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPriceNight(double priceNight) {
        this.pricePerNight = priceNight;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return  false;
        Room room = (Room) o;
        return id == room.id;
    }
}
