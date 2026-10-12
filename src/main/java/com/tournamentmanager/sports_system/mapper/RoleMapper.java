package com.tournamentmanager.sports_system.mapper;

import com.tournamentmanager.sports_system.dto.role.*;
import com.tournamentmanager.sports_system.entity.Role;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RoleMapper {
    public Role toEntity(CreateRoleDTO dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        return role;
    }
    public void updateEntity(UpdateRoleDTO dto, Role role) {
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
    }
    public RoleResponseDTO toResponseDTO(Role role) {
        return new RoleResponseDTO(role.getId(), role.getName(), role.getDescription());
    }
    public List<RoleResponseDTO> toResponseDTOList(List<Role> roles) {
        return roles.stream().map(this::toResponseDTO).toList();
    }
}
