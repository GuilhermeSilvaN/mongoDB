package com.restaurant.workshopmongodb.record;

import com.restaurant.workshopmongodb.models.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;

    public AuthorDTO(){}

    public AuthorDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
}
