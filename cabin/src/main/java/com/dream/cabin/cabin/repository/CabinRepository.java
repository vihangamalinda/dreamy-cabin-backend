package com.dream.cabin.cabin.repository;

import com.dream.cabin.cabin.model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long> {
   List<Cabin> findByIsActiveTrue();
}
