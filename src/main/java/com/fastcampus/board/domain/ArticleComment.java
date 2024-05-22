package com.fastcampus.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "comment"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
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
