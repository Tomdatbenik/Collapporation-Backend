package com.collapporation.tokenservice.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.collapporation.tokenservice.dispatcher.Dispatcher;
import com.collapporation.tokenservice.events.UserLoggedInEvent;
import com.collapporation.tokenservice.token.TokenBuilder;
import com.collapporation.tokenservice.token.TokenValidator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController {
    private final Logger logger = LoggerFactory.getLogger(TokenController.class);
    private final TokenBuilder tokenBuilder;
    private final TokenValidator tokenValidator;
    private final FirebaseAuth firebaseAuth;
    private final Dispatcher dispatcher;

    @GetMapping("/new")
    public ResponseEntity<String> newToken(@RequestHeader("idToken") String idToken) {
        try {
            logger.info("getting firebase token");
            final FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(idToken);
            logger.info("dispatching event");
            dispatcher.dispatch("user",new UserLoggedInEvent(
                    firebaseToken.getUid(),
                    firebaseToken.getName(),
                    "",
                    "",
                    firebaseToken.getPicture()
            ));
            logger.info("generating token");
            return new ResponseEntity<>(tokenBuilder.getNewToken(
                    firebaseToken.getUid(), firebaseToken.getName(), firebaseToken.getPicture()), HttpStatus.OK);
        } catch (FirebaseAuthException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refreshToken(@RequestHeader("collapporationToken") String token) {
        try {
            logger.info("verifying collapporation token");
            final DecodedJWT decodedJWT = tokenValidator.verify(token);
            logger.info("generating token");
            return new ResponseEntity<>(tokenBuilder.getNewToken(
                    decodedJWT.getClaim("uuid").asString(),
                    decodedJWT.getClaim("userName").asString(),
                    decodedJWT.getClaim("userImage").asString()), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

}
