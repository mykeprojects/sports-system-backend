package com.tournamentmanager.sports_system.repository;

import com.tournamentmanager.sports_system.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
