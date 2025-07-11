package com.dream.cabin.cabin.service;

import com.dream.cabin.cabin.model.Setting;

import java.util.List;

public interface SettingService {
    Setting getSettingById(final long settingId);

    Setting createSetting(Setting setting);

    List<Setting> getAll();
}
