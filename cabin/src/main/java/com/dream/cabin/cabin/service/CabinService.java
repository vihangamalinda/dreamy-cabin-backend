package com.dream.cabin.cabin.service;

import com.dream.cabin.cabin.model.Cabin;

import java.util.List;


public interface CabinService {
    List<Cabin> getAllCabins();

    void createCabin(Cabin cabin);

    Cabin getCabinById(long cabinId);

    void delete(long cabId);

}
