package com.collapporation.projectservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectFeedDTO extends BasicDTO{
    private List<Object> tags;
    private int likes;
    private boolean follow;
}
