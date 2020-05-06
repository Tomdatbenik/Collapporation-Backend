package com.collapporation.projectservice.service;

import com.collapporation.projectservice.config.RestConfig;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.Projection.IProjectFeed;
import com.collapporation.projectservice.repo.ProjectRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedService {
    private final ProjectRepo projectRepo;

    private final RestTemplate restTemplate;

    public List<IProjectFeed> getProjectFeed(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        List<IProjectFeed> projectFeedList = projectRepo.findAllByOrderByCreatedDesc(pageable);

        projectFeedList.stream().forEach(p -> {
            p.setOwnerId("hallo");
        });
        return projectFeedList;
    }
}
