package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.Guest;
import com.dream.cabin.cabin.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Guest>> getAll() {
        List<Guest> guests = this.guestService.getAll();
        return ResponseEntity.ok(guests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(final @PathVariable("id") long id) {
        Guest guest = this.guestService.getGuestById(id);
        return ResponseEntity.ok(guest);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Boolean>> createGuest(final @RequestBody Guest guest) {
        this.guestService.createGuest(guest);
        return ResponseEntity.ok(Map.of("hasCreated", true));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> deleteGuestById(final @PathVariable("id") long guestId) {
        this.guestService.deleteGuestById(guestId);
        return ResponseEntity.ok(Map.of("hasDeleted", true));
    }
}
