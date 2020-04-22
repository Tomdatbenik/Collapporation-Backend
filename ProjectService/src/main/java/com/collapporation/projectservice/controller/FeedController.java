package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import com.collapporation.projectservice.service.FeedService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class FeedController {
    private final FeedService feedService;

    @GetMapping("/all")
    public List<ProjectFeedDTO> getProjectfeeds(@Param("page") int page, @Param("size") int size){
        return feedService.
    }
}
