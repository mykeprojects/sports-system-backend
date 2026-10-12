package com.tournamentmanager.sports_system.service;

import com.tournamentmanager.sports_system.dto.userrole.*;
import com.tournamentmanager.sports_system.entity.UserRole;
import com.tournamentmanager.sports_system.exception.*;
import com.tournamentmanager.sports_system.mapper.UserRoleMapper;
import com.tournamentmanager.sports_system.repository.UserRoleRepository;
import com.tournamentmanager.sports_system.repository.RoleRepository;
import com.tournamentmanager.sports_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository repository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleMapper mapper;

    @Transactional
    public UserRoleResponseDTO create(CreateUserRoleDTO dto) {
        if (repository.existsByUserIdAndRoleId(dto.getUserId(), dto.getRoleId())) {
            throw new ApplicationException(
                    ErrorCase.CONFLICT,
                    "El usuario ya tiene asignado ese rol"
            );
        }
        UserRole userRole = new UserRole();
        userRole.setUser(userRepository.findById(dto.getUserId()).orElseThrow(() -> new ApplicationException(
                ErrorCase.NOT_FOUND, "Usuario no encontrado con id: " + dto.getUserId())));
        userRole.setRole(roleRepository.findById(dto.getRoleId()).orElseThrow(() -> new ApplicationException(
                ErrorCase.NOT_FOUND, "Rol no encontrado con id: " + dto.getRoleId())));
        return mapper.toResponseDTO(repository.save(userRole));
    }

    @Transactional(readOnly = true)
    public List<UserRoleResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    @Transactional(readOnly = true)
    public List<UserRoleResponseDTO> findByUserId(Long userId) {
        return mapper.toResponseDTOList(repository.findAllByUserId(userId));
    }

    @Transactional(readOnly = true)
    public List<RoleUserResponseDTO> findByRoleId(Long roleId) {
        return mapper.toRoleUserResponseDTOList(repository.findAllByRoleId(roleId));
    }

    @Transactional(readOnly = true)
    public UserRoleResponseDTO findById(Long id) {
        return mapper.toResponseDTO(findEntity(id));
    }

    @Transactional
    public void delete(Long userId, Long roleId) {
        repository.delete(repository.findByUserIdAndRoleId(userId, roleId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Asignación de rol no encontrada"
                )));
    }
    private UserRole findEntity(Long id) { return repository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCase.NOT_FOUND, "Relación usuario-rol no encontrada con id: " + id)); }
}
