package com.restaurant.workshopmongodb.repositories;

import com.restaurant.workshopmongodb.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    public List<Post> searchTitle(String title);

    public List<Post> findByTitleContainingIgnoreCase(@RequestParam(value="text", defaultValue="") String title);

    @Query("{ $and: [ " +
            "  { date: { $gte: ?1, $lte: ?2 } }, " +
            "  { $or: [ " +
            "      { title: { $regex: ?0, $options: 'i' } }, " +
            "      { body: { $regex: ?0, $options: 'i' } }, " +
            "      { 'comments.text': { $regex: ?0, $options: 'i' } } " +
            "  ] } " +
            "] }")
    public List<Post> fullSearch(String text, Date from, Date to);
}
