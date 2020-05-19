package com.collapporation.likeservice.models.dto;

import com.collapporation.likeservice.models.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeCountDto extends BasicDTO{

    public LikeCountDto(String object_id) {
        object_id = object_id;
    }

    private String object_id;
    private long count;
}
