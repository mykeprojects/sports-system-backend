package com.tournamentmanager.sports_system.service;

import com.tournamentmanager.sports_system.dto.rolepermission.*;
import com.tournamentmanager.sports_system.entity.RolePermission;
import com.tournamentmanager.sports_system.exception.*;
import com.tournamentmanager.sports_system.mapper.RolePermissionMapper;
import com.tournamentmanager.sports_system.repository.RolePermissionRepository;
import com.tournamentmanager.sports_system.repository.PermissionRepository;
import com.tournamentmanager.sports_system.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolePermissionService {
    private final RolePermissionRepository repository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RolePermissionMapper mapper;
    public RolePermissionResponseDTO create(CreateRolePermissionDTO dto) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(roleRepository.findById(dto.getRoleId()).orElseThrow(() -> new ApplicationException(
                ErrorCase.NOT_FOUND, "Rol no encontrado con id: " + dto.getRoleId())));
        rolePermission.setPermission(permissionRepository.findById(dto.getPermissionId()).orElseThrow(() -> new ApplicationException(
                ErrorCase.NOT_FOUND, "Permiso no encontrado con id: " + dto.getPermissionId())));
        return mapper.toResponseDTO(repository.save(rolePermission));
    }
    public List<RolePermissionResponseDTO> findAll() { return mapper.toResponseDTOList(repository.findAll()); }
    public RolePermissionResponseDTO findById(Long id) { return mapper.toResponseDTO(findEntity(id)); }
    public void delete(Long id) { repository.delete(findEntity(id)); }
    private RolePermission findEntity(Long id) { return repository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCase.NOT_FOUND, "Relación rol-permiso no encontrada con id: " + id)); }
}
