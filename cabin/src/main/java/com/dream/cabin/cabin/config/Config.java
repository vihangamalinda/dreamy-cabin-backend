package com.dream.cabin.cabin.config;

import com.dream.cabin.cabin.repository.CabinRepository;
import com.dream.cabin.cabin.repository.GuestRepository;
import com.dream.cabin.cabin.service.CabinService;
import com.dream.cabin.cabin.service.GuestService;
import com.dream.cabin.cabin.service.impl.CabinServiceImpl;
import com.dream.cabin.cabin.service.impl.GuestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public CabinService getCabinService(CabinRepository cabinRepository) {
        return new CabinServiceImpl(cabinRepository);
    }

    @Bean
    public GuestService getGuestService(GuestRepository guestRepository) {
        return new GuestServiceImpl(guestRepository);
    }
}

