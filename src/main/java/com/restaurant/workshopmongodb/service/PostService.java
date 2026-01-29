package com.restaurant.workshopmongodb.service;

import com.restaurant.workshopmongodb.models.Post;
import com.restaurant.workshopmongodb.record.PostDTO;
import com.restaurant.workshopmongodb.repositories.PostRepository;
import com.restaurant.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(String id){
        if(postRepository.existsById(id)){
            return new PostDTO(postRepository.findById(id).get());
        } else {
            throw new ObjectNotFoundException("Post not found");
        }
    }

    public List<PostDTO> findByTitle(String title){
        List<Post> posts = postRepository.searchTitle(title);
        return posts.stream().map(PostDTO::new).collect(Collectors.toList());
    }

    public List<PostDTO> findFullSearch(String title, Date from, Date to){

        Date maxDate = new Date(to.getTime() + 24 * 60 * 60 * 1000);

        String regex = ".*" + title + ".*";

        List<Post> posts = postRepository.fullSearch(regex, from, maxDate);

        return posts.stream().map(PostDTO::new).collect(Collectors.toList());
    }

}
