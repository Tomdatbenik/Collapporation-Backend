package com.collapporation.likeservice.event;

import com.collapporation.likeservice.models.Like;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LikeCreatedEvent extends Event{
    private Like like;
}
