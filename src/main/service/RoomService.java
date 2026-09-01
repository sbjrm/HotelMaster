package main.service;

import main.exception.NotFoundException;
import main.model.Room;
import main.repository.RoomRepository;

import java.util.List;

public class RoomService {
    private RoomRepository roomRepository;

    public Room findById(int id) throws NotFoundException {
        return roomRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Комната с id = " + id + " не найдена"));
    }

    public boolean updateById(int id, Room room) throws NotFoundException {
        findById(id);
        return roomRepository
                .update(room);
    }

    public boolean deleteById(int id) throws NotFoundException {
        findById(id);
        return roomRepository
                .delete(id);
    }

    public List<Room> findAll() {
        return roomRepository
                .findAll();
    }

    public Room findByRoomNumber(String roomNumber) throws NotFoundException {
        return roomRepository
                .findByRoomNumber(roomNumber)
                .orElseThrow(() -> new NotFoundException("Комната с номером " + roomNumber + " не найдена"));
    }

    public RoomService() {
        this.roomRepository = RoomRepository.getInstance();
    }

    public Room create (Room room) {
        return roomRepository.save(room);
    }

    public void printAllRooms() {
        System.out.println("Показываем все номера");
    }
}

