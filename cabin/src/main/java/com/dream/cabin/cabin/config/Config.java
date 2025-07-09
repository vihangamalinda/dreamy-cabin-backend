package com.dream.cabin.cabin.config;

import com.dream.cabin.cabin.repository.CabinRepository;
import com.dream.cabin.cabin.service.CabinService;
import com.dream.cabin.cabin.service.impl.CabinServiceImpl;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public CabinService getCabinService(CabinRepository cabinRepository) {
        System.out.println("Vihanga");

        System.out.println(cabinRepository);
        return new CabinServiceImpl(cabinRepository);
    }
}

