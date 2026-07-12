package repository;

import model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    public Room save(Room room) {
        rooms.add(room);
        return room;
    }

    public Optional<Room> findById(int id) {
        return rooms
                .stream()
                .filter(room -> room.getId() == id)
                .findFirst();
    }

    private Integer getNextId() {
        int max = rooms
                .stream()
                .mapToInt(Room::getId)
                .max()
                .orElse(0);

        return ++max;
    }



    public Optional<Room> findByRoomNumber(String roomNumber) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst();
    }

    public List<Room> findAll() {
        return new ArrayList<>(rooms);
    }

    public boolean update(Room updateRoom) {
        Optional<Room> existingRoom = findById(updateRoom.getId());
        if (existingRoom.isPresent()) {
            Room room = existingRoom.get();
            room.setRoomNumber(updateRoom.getRoomNumber());
            room.setType(updateRoom.getType());
            room.setPriceNight(room.getPricePerNight());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return rooms.removeIf(room -> room.getId() == id);
    }

    public void clear() {
        rooms.clear();
    }


}
