package com.collapperations.userservice.repo;

import com.collapperations.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
