package com.tournamentmanager.sports_system.mapper;

import com.tournamentmanager.sports_system.dto.rolepermission.RolePermissionResponseDTO;
import com.tournamentmanager.sports_system.entity.RolePermission;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RolePermissionMapper {
    public RolePermissionResponseDTO toResponseDTO(RolePermission rolePermission) {
        return new RolePermissionResponseDTO(rolePermission.getId(), rolePermission.getRole().getId(), rolePermission.getPermission().getId());
    }
    public List<RolePermissionResponseDTO> toResponseDTOList(List<RolePermission> rolePermissions) {
        return rolePermissions.stream().map(this::toResponseDTO).toList();
    }
}
