package com.collapporation.likeservice.models;

import com.collapporation.likeservice.models.dto.LikeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "like")
@Table(name = "like_table")
public class Like {
    @Id
    @JsonProperty("id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @JsonProperty("object_id")
    @Column(name = "object_id")
    private String object_id;

    @JsonProperty("liked_by_id")
    @Column(name = "liked_by_id")
    private String liked_by_id;

    public Like(String object_id, String liked_by_id) {
        this.object_id = object_id;
        this.liked_by_id = liked_by_id;
    }

    public Like(LikeDto likeDto)
    {
        this.object_id = likeDto.getObject_id();
    }
}
