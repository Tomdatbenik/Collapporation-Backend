package com.collapperation.userservice.repo;

import com.collapperation.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
