package com.collapporation.likeservice.models.projection;

import com.collapporation.likeservice.models.ProjectStatus;

import java.time.LocalDateTime;

public interface IProjectFeed {
    String getId();
    String getTitle();
    String getSmallDescription();
    ProjectStatus getStatus();
    String getImg();
    //TODO change ownerid to owner
    String getOwnerId();
    void setOwnerId(String ownerId);
    LocalDateTime getCreated();
}
