package com.hungpham.service;

import com.hungpham.dtos.NewsDto;
import com.hungpham.entity.NewsEntity;

import java.util.List;

public interface NewsService {
    List<NewsEntity> getAllNews();
    NewsEntity getNewsById(String id);
    List<NewsEntity> getNewsByAuthor(String author);

    NewsEntity createNewNew(NewsDto newsDto);
    NewsEntity updateNew(NewsDto newsDto);
    NewsEntity deleteNew(String id);
}
