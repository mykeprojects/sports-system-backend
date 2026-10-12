package com.tournamentmanager.sports_system.controller;

import com.tournamentmanager.sports_system.dto.profile.CreateProfileDTO;
import com.tournamentmanager.sports_system.dto.profile.UpdateProfileDTO;
import com.tournamentmanager.sports_system.dto.profile.ProfileResponseDTO;
import com.tournamentmanager.sports_system.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users/{userId}/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponseDTO create(
            @PathVariable Long userId,
            @Valid @RequestBody CreateProfileDTO dto) {
        return profileService.create(userId, dto);
    }

    @GetMapping
    public ProfileResponseDTO findByUserId(@PathVariable Long userId) {
        return profileService.findByUserId(userId);
    }

    @PutMapping
    public ProfileResponseDTO update(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateProfileDTO dto) {
        return profileService.update(userId, dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        profileService.delete(userId);
    }
}
