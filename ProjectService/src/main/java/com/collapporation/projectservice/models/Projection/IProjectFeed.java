package com.collapporation.projectservice.models.Projection;

import com.collapporation.projectservice.models.ProjectStatus;

import java.time.LocalDateTime;

public interface IProjectFeed {
    String getId();
    String getTitle();
    String getSmallDescription();
    ProjectStatus getStatus();
    String getImg();
    //TODO change ownerid to owner
    String getOwnerId();
    LocalDateTime getCreated();
}
