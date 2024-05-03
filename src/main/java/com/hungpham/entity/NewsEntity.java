package com.hungpham.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "news")
public class NewsEntity  extends baseEntity{
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryEntity category;

    @Column(name = "content")
    private String content;

    @Column(name = "short_description")
    private String shortDescription;

    @OneToOne
    @JoinColumn(name = "author")
    private UserEntity author;

    @Column(name = "delete_flag")
    private Boolean deleteFlag;
}
