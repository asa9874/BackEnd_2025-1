package com.example.bcsd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("/articles")
public class ArticleController {
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getArticle(@PathVariable String id){
        return ResponseEntity.ok().body("");
    }

    @PostMapping()
    public ResponseEntity<String> createArticle(@RequestBody String article){
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArticle(@PathVariable String id, @RequestBody String article){
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable String id){
        return ResponseEntity.ok().body("");
    }
    
    
}
