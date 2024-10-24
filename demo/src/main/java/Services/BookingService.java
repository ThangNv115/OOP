package Services;

import Entity.Booking;
import Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    //dat ve
    public Booking createBooking(Booking booking) {
        booking.setBookingDate(new Date());
        booking.setPaymentStatus("Dang xu ly");
        return bookingRepository.save(booking);
    }
}
