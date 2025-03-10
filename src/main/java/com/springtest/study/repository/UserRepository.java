package com.springtest.study.repository;

import com.springtest.study.entry.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntry, Long> {
    Optional<UserEntry> findByName(String name);
}
