package com.tournamentmanager.sports_system.service;

import com.tournamentmanager.sports_system.dto.profile.CreateProfileDTO;
import com.tournamentmanager.sports_system.dto.profile.UpdateProfileDTO;
import com.tournamentmanager.sports_system.dto.profile.ProfileResponseDTO;
import com.tournamentmanager.sports_system.entity.Profile;
import com.tournamentmanager.sports_system.entity.User;
import com.tournamentmanager.sports_system.exception.ApplicationException;
import com.tournamentmanager.sports_system.exception.ErrorCase;
import com.tournamentmanager.sports_system.mapper.ProfileMapper;
import com.tournamentmanager.sports_system.repository.ProfileRepository;
import com.tournamentmanager.sports_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponseDTO create(Long userId, CreateProfileDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Usuario no encontrado con id: " + userId
                ));

        if (profileRepository.existsByUserId(userId)) {
            throw new ApplicationException(
                    ErrorCase.ALREADY_EXISTS,
                    "El usuario ya tiene un perfil"
            );
        }

        Profile profile = profileMapper.toEntity(dto);
        profile.setUser(user);

        Profile savedProfile = profileRepository.save(profile);
        return profileMapper.toResponseDTO(savedProfile);
    }

    public ProfileResponseDTO update(Long userId, UpdateProfileDTO dto) {
        Profile profile = findProfile(userId);

        profileMapper.updateEntity(dto, profile);
        Profile updatedProfile = profileRepository.save(profile);

        return profileMapper.toResponseDTO(updatedProfile);
    }

    public ProfileResponseDTO findByUserId(Long userId) {
        return profileMapper.toResponseDTO(findProfile(userId));
    }

    public void delete(Long userId) {
        profileRepository.delete(findProfile(userId));
    }

    private Profile findProfile(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Perfil no encontrado para el usuario con id: " + userId
                ));
    }
}
