package com.dream.cabin.cabin.config;

import com.dream.cabin.cabin.repository.*;
import com.dream.cabin.cabin.service.*;
import com.dream.cabin.cabin.service.impl.*;
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

    @Bean
    public UserService getUserService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}

