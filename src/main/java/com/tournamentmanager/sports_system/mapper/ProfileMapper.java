package com.tournamentmanager.sports_system.mapper;

import com.tournamentmanager.sports_system.dto.profile.*;
import com.tournamentmanager.sports_system.entity.Profile;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProfileMapper {
    public Profile toEntity(CreateProfileDTO dto) {
        Profile profile = new Profile();
        profile.setPhone(dto.getPhone());
        profile.setBirthDate(dto.getBirthDate());
        return profile;
    }
    public void updateEntity(UpdateProfileDTO dto, Profile profile) {
        profile.setPhone(dto.getPhone());
        profile.setBirthDate(dto.getBirthDate());
    }
    public ProfileResponseDTO toResponseDTO(Profile profile) {
        if(profile == null){
            return null;
        }

        return new ProfileResponseDTO(profile.getId(), profile.getUser().getId(), profile.getPhone(), profile.getBirthDate());
    }
    public List<ProfileResponseDTO> toResponseDTOList(List<Profile> profiles) {
        return profiles.stream().map(this::toResponseDTO).toList();
    }
}
