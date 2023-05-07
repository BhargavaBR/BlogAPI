package com.Project.BlogAPI.Commons;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @CreatedDate
    Date createdAt;
}
