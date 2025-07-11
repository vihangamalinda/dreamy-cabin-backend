package com.dream.cabin.cabin.repository;

import com.dream.cabin.cabin.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository  extends JpaRepository<Booking,Long> {
    List<Booking> findByIsActiveTrue();
}
