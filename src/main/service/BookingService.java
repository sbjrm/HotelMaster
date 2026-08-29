package main.service;

import main.exception.NotFoundException;
import main.model.Booking;
import main.repository.BookingRepository;
import main.repository.ClientRepository;
import main.repository.RoomRepository;

public class BookingService {
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public BookingService() {
        this.clientRepository = ClientRepository.getInstance();
        this.roomRepository = RoomRepository.getInstance();
        this.bookingRepository = BookingRepository.getInstance();
    }

    public Booking create(Booking booking) throws NotFoundException {
        roomRepository
                .findById(booking.getRoom().getId())
                .orElseThrow(() -> new NotFoundException("Комната не найдена"));

        clientRepository
                .findById(booking.getClient().getId())
                .orElseThrow(() -> new NotFoundException("Клиент не найден"));

        return bookingRepository.save(booking);
    }
}
