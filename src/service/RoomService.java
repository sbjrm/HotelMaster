package service;

import model.Room;
import repository.RoomRepository;

public class RoomService {
    private RoomRepository roomRepository;

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

