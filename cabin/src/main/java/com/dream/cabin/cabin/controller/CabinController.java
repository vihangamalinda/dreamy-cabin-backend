package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.Cabin;
import com.dream.cabin.cabin.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/cabins")
public class CabinController {
    private CabinService cabinService;

    @Autowired
    CabinController(CabinService cabinService) {
        this.cabinService = cabinService;
    }

    @GetMapping("/all")
    public List<Cabin> getAllCabins() {
        List<Cabin> cabins = cabinService.getAllCabins();
        return cabins;
    }

    @PostMapping("/create")
    public List<Cabin> createCabin(@RequestBody Cabin cabin) {
        cabinService.createCabin(cabin);
        return null;
    }

    @GetMapping("/{id}")
    public Cabin getCabinById(@PathVariable("id") long cabinId) {
        return cabinService.getCabinById(cabinId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") long cabId) {
        cabinService.delete(cabId);
        return ResponseEntity.ok(Map.of("hasDeleted", true));
    }


}
