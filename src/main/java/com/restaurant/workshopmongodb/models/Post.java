package com.restaurant.workshopmongodb.models;

import com.restaurant.workshopmongodb.record.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;;
    private String description;

    private AuthorDTO author;

    private List<Comment> comments = new ArrayList<>();

    public Post() {}

    public Post(String id, Date date, String title, String description, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.author = author;
    }
}
