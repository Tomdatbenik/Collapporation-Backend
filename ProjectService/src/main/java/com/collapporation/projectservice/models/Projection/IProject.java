package com.collapporation.projectservice.models.Projection;

import com.collapporation.projectservice.models.ProjectStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface IProject {
    String getId();
    String getTitle();
    String getDescription();
    String getSmallDescription();
    ProjectStatus getStatus();
    String getImg();
    String getOwnerId();
    LocalDateTime getCreated();
    List<Object> getTags();
    List<Object> getLinks();
    List<Object> getCollaborators();
    List<Object> getComments();
    List<Object> getLikes();
    List<Object> getFollows();
}
