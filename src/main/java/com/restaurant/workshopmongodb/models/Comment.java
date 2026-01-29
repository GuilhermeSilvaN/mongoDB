package com.restaurant.workshopmongodb.models;

import com.restaurant.workshopmongodb.record.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Date date;
    private String text;

    private AuthorDTO author;
}
