package com.Project.BlogAPI.Articles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping("")
    ResponseEntity<String> getAllArticles(){
        return  ResponseEntity.ok("All Articles");
    }
}
