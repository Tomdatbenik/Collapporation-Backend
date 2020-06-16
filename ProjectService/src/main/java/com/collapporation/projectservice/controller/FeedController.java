package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import com.collapporation.projectservice.service.FeedService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/projectfeed")
@Log4j2
public class FeedController {
    private final FeedService feedService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectFeedDTO>> getProjectfeeds(@Param("page") int page, @Param("size") int size){
        log.info("received");
        List<ProjectFeedDTO> projectFeed = feedService.getProjectFeed(page, size);

        log.info("returning");

        return new ResponseEntity<>(projectFeed, HttpStatus.OK);
    }

    //TODO Add more filter versions of the getProjectFeed
}
