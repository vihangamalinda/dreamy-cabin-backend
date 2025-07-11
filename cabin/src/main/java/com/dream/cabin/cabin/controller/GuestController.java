package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.Guest;
import com.dream.cabin.cabin.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/guests")
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
    public ResponseEntity<Guest> createGuest(final @RequestBody Guest guest) {
       Guest savedGuest = this.guestService.createGuest(guest);
        String path =String.format("/%d",savedGuest.getId());
        String uriLocation = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString().replace("/create","").concat(path);
        return ResponseEntity.created(URI.create(uriLocation)).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGuestById(final @PathVariable("id") long guestId) {
        this.guestService.deleteGuestById(guestId);
        return ResponseEntity.ok(Map.of("hasDeleted", true));
    }
}
