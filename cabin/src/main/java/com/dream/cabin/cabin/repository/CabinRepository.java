package com.dream.cabin.cabin.repository;

import com.dream.cabin.cabin.model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinRepository extends JpaRepository<Cabin,Integer> {
}
