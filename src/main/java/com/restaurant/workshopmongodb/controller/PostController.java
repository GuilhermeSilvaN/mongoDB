package com.restaurant.workshopmongodb.controller;

import com.restaurant.workshopmongodb.controller.util.URL;
import com.restaurant.workshopmongodb.record.PostDTO;
import com.restaurant.workshopmongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitleSearch(@RequestParam(value="text", defaultValue="") String title){
        URL.decodingParam(title);
        List<PostDTO> list = postService.findByTitle(title);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostDTO>> findByFullSearch(@RequestParam(value="text", defaultValue="") String text,
                                                          @RequestParam(value="minDate", defaultValue = "") String minDate,
                                                          @RequestParam(value="maxDate", defaultValue = "") String maxDate
                                                          ){
        URL.decodingParam(text);
        Date min = URL.convertStringToDate(minDate, new Date(0L));
        Date max = URL.convertStringToDate(maxDate, new Date());

        List<PostDTO> list = postService.findFullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
