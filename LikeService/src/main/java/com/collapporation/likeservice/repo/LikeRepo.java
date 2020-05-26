package com.collapporation.likeservice.repo;

import com.collapporation.likeservice.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepo extends JpaRepository<Like, String> {

    @Query("SELECT COUNT(l) FROM like l WHERE l.object_id = :object_id")
    long countByObjectId(@Param("object_id") String object_id);

    @Query("SELECT l FROM like l WHERE l.object_id = :object_id")
    List<Like> findAllByObject_id(@Param("object_id") String object_id);

    @Query("SELECT l FROM like l WHERE l.object_id = :object_id AND l.liked_by_id = :liked_by_id ")
    Like getLikeByObjectAndLikedBy(@Param("object_id") String object_id,@Param("liked_by_id") String liked_by_id);
}
