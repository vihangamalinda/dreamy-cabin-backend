package com.dream.cabin.cabin.service;

import com.dream.cabin.cabin.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAll();
    Booking getBookingsById(long bookingId);

    void updateBookingStatus(Booking booking,long bookingId);

    void createBooking(Booking booking);

    void deleteBookingById(long id);
}
