package com.collapporation.likeservice.controller;

import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.LikeCollection;
import com.collapporation.likeservice.models.dto.LikeCountDto;
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


    //TODO return something else when friends are implemented to see also liked it.
    @GetMapping("/count")
    public ResponseEntity getLikeCountDto(String object_id)
    {
        LikeCollection collection = likeService.getLikeCollectionByObjectId(object_id);
        LikeCountDto likeCountDto = new LikeCountDto(object_id, collection.getCount());
        return new ResponseEntity(likeCountDto, HttpStatus.OK);
    }
}
