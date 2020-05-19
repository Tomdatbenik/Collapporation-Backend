package com.collapporation.likeservice.models.projection;

import com.collapporation.likeservice.models.ProjectStatus;

import java.time.LocalDateTime;

public interface IProject {
    String getId();
    String getTitle();
    String getDescription();
    String getSmallDescription();
    ProjectStatus getStatus();
    String getImg();
    String getOwnerId();
    LocalDateTime getCreated();
    String getTags();
    String getLinks();
    String getCollaborators();
    String getComments();
    String getLikes();
    String getFollows();

    void setTags(String tags);
    void setLinks(String links);
    void setCollaborators(String Collaborators);
    void setComments(String comments);
    void setLikes(String likes);
    void setFollows(String follows);


}
