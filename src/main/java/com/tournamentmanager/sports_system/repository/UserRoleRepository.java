package com.tournamentmanager.sports_system.repository;

import com.tournamentmanager.sports_system.entity.UserRole;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    boolean existsByUserIdAndRoleId(Long userId, Long roleId);

    @EntityGraph(attributePaths = {"user", "role"})
    List<UserRole> findAllByUserId(Long userId);

    @EntityGraph(attributePaths = {"user", "role"})
    List<UserRole> findAllByRoleId(Long roleId);

    @Override
    @EntityGraph(attributePaths = {"user", "role"})
    List<UserRole> findAll();

    @Override
    @EntityGraph(attributePaths = {"user", "role"})
    Optional<UserRole> findById(Long id);

    @EntityGraph(attributePaths = {"user", "role"})
    Optional<UserRole> findByUserIdAndRoleId(Long userId, Long roleId);

    boolean existsByRoleId(Long roleId);
}
