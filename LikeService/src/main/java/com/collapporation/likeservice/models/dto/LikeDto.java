package com.collapporation.likeservice.models.dto;

import com.collapporation.likeservice.models.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikeDto {

    public LikeDto(Like like) {
        this.object_id = like.getObject_id();
    }

    private String object_id;
}
