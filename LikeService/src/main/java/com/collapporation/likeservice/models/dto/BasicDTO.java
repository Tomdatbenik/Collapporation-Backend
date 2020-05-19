package com.collapporation.likeservice.models.dto;

import com.collapporation.likeservice.models.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BasicDTO {
    public BasicDTO(Like like) {
        this.id = like.getId();

    }

    private String id;
}
