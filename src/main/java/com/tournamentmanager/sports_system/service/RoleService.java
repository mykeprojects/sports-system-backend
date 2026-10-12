package com.tournamentmanager.sports_system.service;

import com.tournamentmanager.sports_system.dto.role.*;
import com.tournamentmanager.sports_system.entity.Role;
import com.tournamentmanager.sports_system.exception.*;
import com.tournamentmanager.sports_system.mapper.RoleMapper;
import com.tournamentmanager.sports_system.repository.RoleRepository;
import com.tournamentmanager.sports_system.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;
    private final UserRoleRepository userRoleRepository;

    public RoleResponseDTO create(CreateRoleDTO dto) {
        if (repository.existsByNameIgnoreCase(dto.getName())) throw new ApplicationException(ErrorCase.ALREADY_EXISTS, "Ya existe un rol con ese nombre");
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }

    public List<RoleResponseDTO> findAll() { return mapper.toResponseDTOList(repository.findAll()); }

    public RoleResponseDTO findById(Long id) { return mapper.toResponseDTO(findEntity(id)); }

    public RoleResponseDTO update(Long id, UpdateRoleDTO dto) {
        Role role = findEntity(id);
        if (repository.existsByNameIgnoreCaseAndIdNot(dto.getName(), id)) throw new ApplicationException(ErrorCase.ALREADY_EXISTS, "El nombre pertenece a otro rol");
        mapper.updateEntity(dto, role);
        return mapper.toResponseDTO(repository.save(role));
    }
    public void delete(Long id) {
        Role role = findEntity(id);
        if (userRoleRepository.existsByRoleId(id)) {
            throw new ApplicationException(
                    ErrorCase.CONFLICT,
                    "No se puede eliminar un rol que está asignado"
            );
        }
        repository.delete(role);
    }

    private Role findEntity(Long id) { return repository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCase.NOT_FOUND, "Rol no encontrado con id: " + id)); }
}
