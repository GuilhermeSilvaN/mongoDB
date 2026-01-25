package com.restaurant.workshopmongodb.record;

import com.restaurant.workshopmongodb.models.User;

import java.io.Serial;
import java.io.Serializable;

public record UserRecord (
        String id,
        String username,
        String email

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserRecord(User user){
        this(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
