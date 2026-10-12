package com.tournamentmanager.sports_system.mapper;

import com.tournamentmanager.sports_system.dto.user.UserResponseDTO;
import com.tournamentmanager.sports_system.dto.userrole.RoleUserResponseDTO;
import com.tournamentmanager.sports_system.dto.userrole.UserRoleResponseDTO;
import com.tournamentmanager.sports_system.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRoleMapper {
    private final RoleMapper roleMapper;

    public UserRoleResponseDTO toResponseDTO(UserRole userRole) {
        return new UserRoleResponseDTO(
                userRole.getId(),
                userRole.getUser().getId(),
                roleMapper.toResponseDTO(userRole.getRole())
        );
    }

    public List<UserRoleResponseDTO> toResponseDTOList(List<UserRole> userRoles) {
        return userRoles.stream().map(this::toResponseDTO).toList();
    }

    public RoleUserResponseDTO toRoleUserResponseDTO(UserRole userRole) {
        var user = userRole.getUser();
        return new RoleUserResponseDTO(
                userRole.getId(),
                userRole.getRole().getId(),
                new UserResponseDTO(user.getId(), user.getName(), user.getEmail())
        );
    }

    public List<RoleUserResponseDTO> toRoleUserResponseDTOList(List<UserRole> userRoles) {
        return userRoles.stream().map(this::toRoleUserResponseDTO).toList();
    }
}
