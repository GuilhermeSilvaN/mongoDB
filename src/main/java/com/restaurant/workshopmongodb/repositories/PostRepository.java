package com.restaurant.workshopmongodb.repositories;

import com.restaurant.workshopmongodb.models.Post;
import com.restaurant.workshopmongodb.record.AuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    public List<Post> searchTitle(String title);

    public List<Post> findByTitleContainingIgnoreCase(@RequestParam(value="text", defaultValue="") String title);
}
