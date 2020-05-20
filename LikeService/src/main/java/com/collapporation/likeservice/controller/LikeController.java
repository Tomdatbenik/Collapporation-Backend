package com.collapporation.likeservice.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.LikeCollection;
import com.collapporation.likeservice.models.dto.LikeCountDto;
import com.collapporation.likeservice.models.dto.LikeDto;
import com.collapporation.likeservice.service.LikeService;
import com.collapporation.likeservice.token.TokenValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private LikeService likeService;
    private final TokenValidator tokenValidator;

    @PostMapping("/like")
        public ResponseEntity createLike(@RequestBody LikeDto likeDto, @RequestHeader("Authorization") String token)
    {
        final DecodedJWT decodedJWT = tokenValidator.verify(token);

        final String uuid = decodedJWT.getClaim("uuid").toString();

        if(likeService.hasAlreadyLiked(uuid))
        {
            Like like = likeService.getLikeByObjectAndLikedBy(likeDto.getObject_id(),likeDto.getLiked_by_id());
            likeService.deleteLike(like);
        }
        else
        {
            likeService.validateLike(new Like((likeDto)));
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
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
