package com.collapporation.likeservice.repo;

import com.collapporation.likeservice.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepo extends JpaRepository<Like, String> {
}
