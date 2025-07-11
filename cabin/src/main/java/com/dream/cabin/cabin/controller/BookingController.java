package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.Booking;
import com.dream.cabin.cabin.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    BookingController(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAll() {
        final List<Booking> bookings = this.bookingService.getAll();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingsById(@PathVariable("id") final long bookingId) {
        final Booking booking = this.bookingService.getBookingsById(bookingId);
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody final Booking booking) {
        Booking savedBooking =bookingService.createBooking(booking);
        String path =String.format("/%d",savedBooking.getId());
        String uriLocation = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString().replace("/create","").concat(path);
        return ResponseEntity.created(URI.create(uriLocation)).build();
    }

    @PutMapping("/update/{bookingId}/status")
    public ResponseEntity<Map<String, Boolean>> updateBookingStatus(@RequestBody final Booking booking,@PathVariable long bookingId) {
        bookingService.updateBookingStatus(booking,bookingId);
        return ResponseEntity.ok(Map.of("hasUpdated", true));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBookingById(@PathVariable("id") final long id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.ok(Map.of("hasDeleted", true));
    }

}
