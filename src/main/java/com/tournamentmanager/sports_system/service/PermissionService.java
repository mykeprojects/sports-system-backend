package com.tournamentmanager.sports_system.service;

import com.tournamentmanager.sports_system.dto.permission.*;
import com.tournamentmanager.sports_system.entity.Permission;
import com.tournamentmanager.sports_system.exception.*;
import com.tournamentmanager.sports_system.mapper.PermissionMapper;
import com.tournamentmanager.sports_system.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository repository;
    private final PermissionMapper mapper;
    public PermissionResponseDTO create(CreatePermissionDTO dto) { return mapper.toResponseDTO(repository.save(mapper.toEntity(dto))); }
    public List<PermissionResponseDTO> findAll() { return mapper.toResponseDTOList(repository.findAll()); }
    public PermissionResponseDTO findById(Long id) { return mapper.toResponseDTO(findEntity(id)); }
    public PermissionResponseDTO update(Long id, UpdatePermissionDTO dto) {
        Permission permission = findEntity(id);
        mapper.updateEntity(dto, permission);
        return mapper.toResponseDTO(repository.save(permission));
    }
    public void delete(Long id) { repository.delete(findEntity(id)); }
    private Permission findEntity(Long id) { return repository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCase.NOT_FOUND, "Permiso no encontrado con id: " + id)); }
}
