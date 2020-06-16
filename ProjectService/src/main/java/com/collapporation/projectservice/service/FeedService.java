package com.collapporation.projectservice.service;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import com.collapporation.projectservice.repo.ProjectRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
@Log4j2
public class FeedService {
    private final ProjectRepo projectRepo;

    private final RestTemplate restTemplate;

    public List<ProjectFeedDTO> getProjectFeed(int page, int size){
        log.info("new request");
        Pageable pageable = PageRequest.of(page, size);

        log.info("getting page");
        List<Project> projectList = projectRepo.findAllByOrderByCreatedDesc(pageable);

        List<ProjectFeedDTO> projectFeedList = new ArrayList<>();

        projectList.stream().forEach(p -> {
            log.info("getting owner: {}", p.getOwnerId());
            ProjectFeedDTO projectFeedDTO = new ProjectFeedDTO(p);
          
            try{
                projectFeedDTO.setOwner(restTemplate.getForObject("http://user-service/user/" + p.getOwnerId(), String.class));
            }
            catch (Exception ex) {
                projectFeedDTO.setOwner("{ name: 'no user could be found' }");
            }
            log.info("adding project");
            projectFeedList.add(projectFeedDTO);
        });

        projectFeedList.removeIf(Objects::isNull);
        log.info("returning");
        return projectFeedList;
    }
}
