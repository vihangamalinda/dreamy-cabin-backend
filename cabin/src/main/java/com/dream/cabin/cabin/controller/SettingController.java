package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.Setting;
import com.dream.cabin.cabin.service.SettingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/settings")
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Setting> createSetting(@RequestBody final Setting setting) {
        Setting savedSettings = this.settingService.createSetting(setting);
        String location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSettings.getId()).toString().replace("/create", "");

        return ResponseEntity.created(URI.create(location)).build();
    }

    /*
    @PutMapping(
    Settings TODO
            */
}
