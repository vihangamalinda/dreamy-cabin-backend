package com.dream.cabin.cabin.service.impl;

import com.dream.cabin.cabin.exception.ResourceNotFoundException;
import com.dream.cabin.cabin.model.Guest;
import com.dream.cabin.cabin.repository.GuestRepository;
import com.dream.cabin.cabin.service.GuestService;

import java.util.List;

public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> getAll() {
        List<Guest> guests = this.guestRepository.findByIsActiveTrue();
        return guests;
    }

    @Override
    public Guest getGuestById(long guestId) {
        Guest guest = this.guestRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Given Guest id was not found %d .", guestId)));
        return guest;
    }

    @Override
    public Guest createGuest(Guest guest) {
       return this.guestRepository.save(guest);
    }

    @Override
    public void deleteGuestById(long guestId) {
        Guest guest = this.getGuestById(guestId);
        guest.setActive(false);
        this.guestRepository.save(guest);
    }
}
