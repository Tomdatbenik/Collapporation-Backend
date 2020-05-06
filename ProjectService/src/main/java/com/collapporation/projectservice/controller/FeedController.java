package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.Projection.IProjectFeed;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import com.collapporation.projectservice.service.FeedService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/projectfeed")
public class FeedController {
    private final FeedService feedService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectFeedDTO>> getProjectfeeds(@Param("page") int page, @Param("size") int size){
        List<ProjectFeedDTO> projectFeed = feedService.getProjectFeed(page, size);

        System.out.println(projectFeed.get(0));

        return new ResponseEntity<>(projectFeed, HttpStatus.OK);
    }

    //TODO Add more filter versions of the getProjectFeed
}
