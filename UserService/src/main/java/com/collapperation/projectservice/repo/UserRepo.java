package com.collapperation.projectservice.repo;

import com.collapperation.projectservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
