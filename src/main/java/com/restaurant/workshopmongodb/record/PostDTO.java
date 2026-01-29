package com.restaurant.workshopmongodb.record;

import com.restaurant.workshopmongodb.models.Comment;
import com.restaurant.workshopmongodb.models.Post;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record PostDTO(
        String id,
        Date date,
        String title,
        String description,
        List<Comment> comments,
        AuthorDTO author
) implements Serializable {
    public PostDTO(Post post){
        this(
            post.getId(),
            post.getDate(),
            post.getTitle(),
            post.getDescription(),
            post.getComments(),
            post.getAuthor()
        );
    }
}
