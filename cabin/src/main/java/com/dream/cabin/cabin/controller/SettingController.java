package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.Setting;
import com.dream.cabin.cabin.service.SettingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/settings")
public class SettingController {
    private final SettingService settingService;

    SettingController(final SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setting> getSettingById(@PathVariable("id") final long id) {
        Setting setting = this.settingService.getSettingById(id);
        return ResponseEntity.ok(setting);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Setting>> getAll() {
        List<Setting> settings = this.settingService.getAll();
        return ResponseEntity.ok(settings);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Boolean>> createSetting(@RequestBody final Setting setting) {
        this.settingService.createSetting(setting);
        return ResponseEntity.ok(Map.of("hasCreated", true));
    }
}
