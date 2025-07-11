package com.dream.cabin.cabin.config;

import com.dream.cabin.cabin.repository.BookingRepository;
import com.dream.cabin.cabin.repository.CabinRepository;
import com.dream.cabin.cabin.repository.GuestRepository;
import com.dream.cabin.cabin.repository.SettingRepository;
import com.dream.cabin.cabin.service.BookingService;
import com.dream.cabin.cabin.service.CabinService;
import com.dream.cabin.cabin.service.GuestService;
import com.dream.cabin.cabin.service.SettingService;
import com.dream.cabin.cabin.service.impl.BookingServiceImpl;
import com.dream.cabin.cabin.service.impl.CabinServiceImpl;
import com.dream.cabin.cabin.service.impl.GuestServiceImpl;
import com.dream.cabin.cabin.service.impl.SettingServiceImpl;
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

    @Bean
    public SettingService getSettingService(SettingRepository settingRepository) {
        return new SettingServiceImpl(settingRepository);
    }

    @Bean
    public BookingService getBookingService(BookingRepository bookingRepository) {
        return new BookingServiceImpl(bookingRepository);
    }
}

