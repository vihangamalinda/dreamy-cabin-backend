package com.dream.cabin.cabin.service.impl;

import com.dream.cabin.cabin.exception.ResourceNotFoundException;
import com.dream.cabin.cabin.model.Cabin;
import com.dream.cabin.cabin.repository.CabinRepository;
import com.dream.cabin.cabin.service.CabinService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class CabinServiceImpl implements CabinService {
    CabinRepository cabinRepository;

    @Autowired
    public CabinServiceImpl(CabinRepository cabinRepository) {
        this.cabinRepository = cabinRepository;
    }

    @Override
    public List<Cabin> getAllCabins() {
        return cabinRepository.findByIsActiveTrue();
    }

    @Override
    public Cabin createCabin(Cabin cabin) {
        return cabinRepository.save(cabin);
    }

    @Override
    public Cabin getCabinById(long cabinId) {
        return cabinRepository.findById(cabinId).orElseThrow(() -> new ResourceNotFoundException(String.format("Given Cabin id was not found %d .", cabinId)));
    }

    @Override
    public void delete(long cabId) {
        Cabin cabin = this.getCabinById(cabId);
        cabin.setIsActive(false);
        cabinRepository.save(cabin);
    }


}
