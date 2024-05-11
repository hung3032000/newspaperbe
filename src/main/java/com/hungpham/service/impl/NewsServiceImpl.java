package com.hungpham.service.impl;

import com.hungpham.common.exception.BadRequestException;
import com.hungpham.dtos.NewsDto;
import com.hungpham.entity.NewsEntity;
import com.hungpham.entity.UserEntity;
import com.hungpham.mappers.NewsMapper;
import com.hungpham.repository.NewsRepository;
import com.hungpham.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NewsServiceImpl implements NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<NewsEntity> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public NewsEntity getNewsById(String id) {
        return newsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("News not found " + id));
    }

    @Override
    public List<NewsEntity> getNewsByAuthor(String author) {
        return newsRepository.getByAuthor(author);
    }

    @Override
    public NewsEntity createNewNew(NewsDto newsDto) {
        UUID uuid = UUID.randomUUID();
        newsDto.setId(String.valueOf(uuid));
        newsDto.setCreatedDate(new Date());
        NewsEntity newsEntity = newsMapper.toEntity(newsDto);
        return newsRepository.save(newsEntity);
    }

    @Override
    public NewsEntity updateNew(NewsDto newsDto) {
        if (null == newsDto.getId()) {
            throw new BadRequestException("Not found new id to update");
        }
        NewsEntity newsEntity = newsRepository.findById(newsDto.getId()).orElseThrow(
                ()-> new EntityNotFoundException("News not found " + newsDto.getId()));
        newsDto.setCreatedDate(newsEntity.getCreatedDate());
        newsDto.setUpdatedDate(new Date());
        NewsEntity finalNewEntity = newsMapper.toEntity(newsDto);
        return newsRepository.save(finalNewEntity);
    }

    @Override
    public NewsEntity deleteNew(String id) {
        NewsEntity newsEntity = newsRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("News not found " + id));
        newsEntity.setDeleteFlag(true);
        newsEntity.setUpdatedDate(new Date());
        return newsRepository.save(newsEntity);
    }


}
