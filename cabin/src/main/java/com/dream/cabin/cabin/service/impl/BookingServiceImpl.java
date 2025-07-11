package com.dream.cabin.cabin.service.impl;

import com.dream.cabin.cabin.exception.ResourceNotFoundException;
import com.dream.cabin.cabin.model.Booking;
import com.dream.cabin.cabin.repository.BookingRepository;
import com.dream.cabin.cabin.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAll() {
        return this.bookingRepository.findByIsActiveTrue();
    }

    @Override
    public Booking getBookingsById(long bookingId) {
        return this.bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException(String.format("Given Setting id was not found %d .", bookingId)));
    }

    @Override
    public void updateBookingStatus(Booking booking,long bookingId) {
        Booking oldBooking = this.getBookingsById(bookingId);
        oldBooking.setStatus(booking.getStatus());
        this.bookingRepository.save(oldBooking);
    }

    @Override
    public Booking createBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public void deleteBookingById(long id) {
        Booking booking = this.getBookingsById(id);
        booking.setActive(false);
    }
}
