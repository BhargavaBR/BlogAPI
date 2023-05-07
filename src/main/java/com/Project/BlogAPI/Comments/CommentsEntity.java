package com.Project.BlogAPI.Comments;

import com.Project.BlogAPI.Articles.AtricleEntity;
import com.Project.BlogAPI.Commons.BaseEntity;
import com.Project.BlogAPI.Users.UsersEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;

@Entity(name = "comments")
public class CommentsEntity extends BaseEntity {
    @Column(length = 100)
    String title;
    @Column(nullable = false,length= 300)
    String body;

    @ManyToOne
    UsersEntity author;

    @ManyToOne
    AtricleEntity atricle;
}
