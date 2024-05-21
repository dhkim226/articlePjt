package com.fastcampus.board.domain;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
public class Article {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long article_id;
    @Column
    private String title;

    @Column
    private String comment;
    @Column
    private String hashtag;
    @Column
    private OffsetDateTime createdAt;
    @Column
    private String createdBy;
    @Column
    private OffsetDateTime modifiedAt;
    @Column
    private String modifiedBy;
}
