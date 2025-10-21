package com.ynewspaper.repository;

import com.ynewspaper.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}