package repository;

import model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private final Map<Integer, Booking> bookings;

    private BookingRepository() {
        this.bookings = new HashMap<>();
    }

    private static class Holder {
        private static final BookingRepository INSTANCE = new BookingRepository();
    }

    public static BookingRepository getInstance() {
        return BookingRepository.Holder.INSTANCE;
    }

    public Booking save (Booking booking) {
        booking.setId(getNextId());
        bookings.put(booking.getId(), booking);
        return bookings.get(booking.getId());
    }

    private Integer getNextId() {
        int max = bookings.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return ++max;
    }
}
