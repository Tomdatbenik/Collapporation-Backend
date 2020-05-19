package com.collapporation.likeservice.service;

import com.collapporation.likeservice.models.Project;
import com.collapporation.likeservice.models.dto.ProjectFeedDTO;
import com.collapporation.likeservice.repo.ProjectRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class FeedService {
    private final ProjectRepo projectRepo;

    private final RestTemplate restTemplate;

    public List<ProjectFeedDTO> getProjectFeed(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        List<Project> projectList = projectRepo.findAllByOrderByCreatedDesc(pageable);

        List<ProjectFeedDTO> projectFeedList = new ArrayList<>();

        projectList.stream().forEach(p -> {
            ProjectFeedDTO projectFeedDTO = new ProjectFeedDTO(p);
            try{
                //TODO get user or group instead of always trying to get a user
                projectFeedDTO.setOwner(restTemplate.getForObject("http://user-service/user/" + p.getOwnerId(), String.class));
            }
            catch (Exception ex) {
                projectFeedDTO.setOwner("{ name: 'no user could be found' }");
            }
            projectFeedList.add(projectFeedDTO);
        });

        projectFeedList.removeIf(Objects::isNull);
        return projectFeedList;
    }
}
