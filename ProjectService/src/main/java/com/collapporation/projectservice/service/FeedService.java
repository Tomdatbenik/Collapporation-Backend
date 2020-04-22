package com.collapporation.projectservice.service;

import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import com.collapporation.projectservice.repo.ProjectRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedService {
    private final ProjectRepo projectRepo;

    public List<ProjectFeedDTO> getProjectFeed(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return projectRepo.findAllByOrderByCreatedDesc(pageable);
    }
}
