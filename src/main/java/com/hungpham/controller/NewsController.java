package com.hungpham.controller;

import com.hungpham.dtos.NewsDto;
import com.hungpham.entity.NewsEntity;
import com.hungpham.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/get-all-news")
    public List<NewsEntity> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/get-by-id")
    public NewsEntity getNewsById(@RequestBody String id) {
        return newsService.getNewsById(id);
    }

    @GetMapping("/get-all-by-author")
    public List<NewsEntity> getNewsByAuthor(@RequestBody String author) {
        return newsService.getNewsByAuthor(author);
    }

    @PostMapping("/create-new-news")
    public NewsEntity createNewNews(@RequestBody NewsDto newsDto){
        return newsService.createNewNew(newsDto);
    }

    @PutMapping("/update-news")
    public NewsEntity updateNews(@RequestBody NewsDto newsDto){
        return newsService.updateNew(newsDto);
    }

    @DeleteMapping
    public NewsEntity deleteNew(@RequestBody String id){
       return newsService.deleteNew(id);
    }
}
