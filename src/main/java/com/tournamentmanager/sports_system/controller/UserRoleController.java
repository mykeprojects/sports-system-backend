package com.tournamentmanager.sports_system.controller;

import com.tournamentmanager.sports_system.dto.userrole.*;
import jakarta.validation.Valid;
import com.tournamentmanager.sports_system.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService service;
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public UserRoleResponseDTO create(@Valid @RequestBody CreateUserRoleDTO dto) { return service.create(dto); }

    @GetMapping public List<UserRoleResponseDTO> findAll() { return service.findAll(); }

    @GetMapping("/users/{userId}") public List<UserRoleResponseDTO> findByUserId(@PathVariable Long userId) { return service.findByUserId(userId); }

    @GetMapping("/roles/{roleId}") public List<RoleUserResponseDTO> findByRoleId(@PathVariable Long roleId) { return service.findByRoleId(roleId); }

    @GetMapping("/{id}") public UserRoleResponseDTO findById(@PathVariable Long id) { return service.findById(id); }

    @DeleteMapping("/{userId}/{roleId}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long userId, @PathVariable Long roleId) { service.delete(userId, roleId); }
}
