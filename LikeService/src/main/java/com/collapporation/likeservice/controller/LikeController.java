package com.collapporation.likeservice.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.collapporation.likeservice.models.Like;
import com.collapporation.likeservice.models.dto.LikeCountDto;
import com.collapporation.likeservice.models.dto.LikeDto;
import com.collapporation.likeservice.service.LikeService;
import com.collapporation.likeservice.token.TokenValidator;
import com.collapporation.likeservice.models.LikeCollection;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/like")
@Log4j2
public class LikeController {

    private final LikeService likeService;
    private final TokenValidator tokenValidator;

    @PostMapping("/like")
    public ResponseEntity createLike(@RequestBody LikeDto likeDto, @RequestHeader("Authorization") String token)
    {
        log.info("Creating like");
        log.info("Validating token: ", token);
        final DecodedJWT decodedJWT = tokenValidator.verify(token);

        final String uuid = decodedJWT.getClaim("uuid").asString();

        if(uuid != null)
        {
            if(likeService.hasAlreadyLiked(likeDto.getObject_id(),uuid))
            {
                Like like = likeService.getLikeByObjectAndLikedBy(likeDto.getObject_id(),uuid);
                likeService.deleteLike(like);
            }
            else
            {
                likeService.validateLike(new Like(likeDto.getObject_id(),uuid));
            }

            log.info("Returning OK");
            return new ResponseEntity(HttpStatus.OK);
        }

        log.warn("Token invalid: ", token);
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }


    //TODO return something else when friends are implemented to see also liked it.
    @GetMapping("/count")
    public ResponseEntity getLikeCountDto(String object_id)
    {
        log.info("Getting like collection");
        LikeCollection collection = likeService.getLikeCollectionByObjectId(object_id);
        log.info("Received like collection");

        LikeCountDto likeCountDto = new LikeCountDto(object_id, collection.getCount());

        log.info("Returning like collection Dto");
        return new ResponseEntity(likeCountDto, HttpStatus.OK);
    }
}
