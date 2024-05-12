//package com.hungpham.mappers.impl;
//
//import com.hungpham.dtos.NewsDto;
//import com.hungpham.entity.NewsEntity;
//import com.hungpham.mappers.INewsMapper;
//
//public class NewsMapper implements INewsMapper {
//    @Override
//    public NewsEntity toEntity(NewsDto newsDto) {
//        if ( newsDto == null ) {
//            return null;
//        }
//        NewsEntity newsEntity = new NewsEntity();
//        newsEntity.setId( newsDto.getId() );
//        newsEntity.setContent(newsDto.getContent());
//        newsEntity.setShortDescription(newsDto.getShortDescription());
//        newsEntity.setTitle(newsDto.getTitle());
//        newsEntity.setCreatedDate(newsDto.getCreatedDate());
//        newsEntity.setUpdatedDate(newsDto.getUpdatedDate());
//        newsEntity.setDeleteFlag(newsDto.getDeleteFlag());
//
//        return newsEntity;
//    }
//
//    @Override
//    public NewsDto toDto(NewsEntity newsEntity) {
//        if ( newsEntity == null ) {
//            return null;
//        }
//        NewsDto newsDto = new NewsDto();
//        newsDto.setId( newsEntity.getId() );
//        newsDto.setContent(newsEntity.getContent());
//        newsDto.setShortDescription(newsEntity.getShortDescription());
//        newsDto.setTitle(newsEntity.getTitle());
//        newsDto.setCreatedDate(newsEntity.getCreatedDate());
//        newsDto.setUpdatedDate(newsEntity.getUpdatedDate());
//        newsDto.setDeleteFlag(newsEntity.getDeleteFlag());
//        return newsDto;
//    }
//}
