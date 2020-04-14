package com.collapperation.userservice.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoggedInEvent extends Event {
    private String uuid;
    private String userName;
    private String firstName;
    private String lastName;
    private String picture;
}
