package com.dream.cabin.cabin.service.impl;

import com.dream.cabin.cabin.model.Setting;
import com.dream.cabin.cabin.repository.SettingRepository;
import com.dream.cabin.cabin.service.SettingService;

import java.util.List;

public class SettingServiceImpl implements SettingService {
    private final SettingRepository settingRepository;

    public SettingServiceImpl(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    public Setting getSettingById(long settingId) {
        return this.settingRepository.findById(settingId).orElseThrow(RuntimeException::new);
    }

    @Override
    public void createSetting(Setting setting) {
        this.settingRepository.save(setting);
    }

    @Override
    public List<Setting> getAll() {
        return this.settingRepository.findAll();
    }
}
