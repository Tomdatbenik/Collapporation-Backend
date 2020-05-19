package com.collapporation.likeservice.service;

import com.collapporation.likeservice.repo.LikeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeService {

    private LikeRepo repo;
}
