package repository;

import model.Room;

import java.util.*;

public class RoomRepository {
    private final Map<Integer, Room> rooms;

    private RoomRepository() {
        this.rooms = new HashMap<>();
    }

    private static class Holder {
        private static final RoomRepository INSTANCE = new RoomRepository();
    }

    public static RoomRepository getInstance() {
        return Holder.INSTANCE;
    }

    public Room save(Room room) {
        room.setId(getNextId());
        rooms.put(getNextId(), room);
        return room;
    }

    public Optional<Room> findById(int id) {
        return Optional.ofNullable(rooms.get(id));
    }

    private Integer getNextId() {
        int max = rooms
                .keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return ++max;
    }


    public Optional<Room> findByRoomNumber(String roomNumber) {
        return Optional.ofNullable(rooms.get(roomNumber));
    }

    public List<Room> findAll() {
        return rooms.values()
                .stream()
                .toList();
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
        return rooms.remove(id) != null;
    }

    public void clear() {
        rooms.clear();
    }

}
