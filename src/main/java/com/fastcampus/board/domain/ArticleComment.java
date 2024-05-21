package com.fastcampus.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

public class ArticleComment {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comment_id;

    @Column
    private String comment;
    @Column
    private OffsetDateTime createdAt;
    @Column
    private String createdBy;
    @Column
    private OffsetDateTime modifiedAt;
    @Column
    private String modifiedBy;
}
