package com.Project.BlogAPI.Articles;

import com.Project.BlogAPI.Commons.BaseEntity;
import com.Project.BlogAPI.Users.UsersEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "articles")
public class AtricleEntity extends BaseEntity {
    @Column(nullable = false,length = 150)
    String title;
    @Column(nullable = false,length = 100)
    String slug;
    @Column(nullable = false,length = 1000)
    String body;
    @Column(length = 50)
    String subtitle;

    @ManyToOne
    UsersEntity author;


    @ManyToMany(targetEntity = UsersEntity.class)
    @JoinTable(
            name = "article_likes",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<UsersEntity> likes;

}
