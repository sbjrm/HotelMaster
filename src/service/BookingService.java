package service;

import exception.NotFoundException;
import model.Booking;
import repository.BookingRepository;
import repository.ClientRepository;
import repository.RoomRepository;

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
