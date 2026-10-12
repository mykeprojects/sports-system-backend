package com.tournamentmanager.sports_system.repository;

import com.tournamentmanager.sports_system.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
