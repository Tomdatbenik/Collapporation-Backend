package com.collapporation.likeservice.controller;

import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private LikeService likeService;

    @PostMapping("/create")
    public ResponseEntity createLike(@RequestBody Like like)
    {
        likeService.createLike(like);
        return new ResponseEntity(HttpStatus.OK);
    }
}
