package com.dream.cabin.cabin.service;

import com.dream.cabin.cabin.model.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> getAll();

    Guest getGuestById(final long guestId);

    void createGuest(final Guest guest);

    void deleteGuestById(final long guestId);
}
