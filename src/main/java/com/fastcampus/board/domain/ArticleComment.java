package com.fastcampus.board.domain;


import javax.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class ArticleComment {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comment_id;

    @Column
    private String content;

    @CreatedDate
    private OffsetDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private OffsetDateTime modifiedAt;

    @LastModifiedBy
    private String modifiedBy;

    // 테이블 연관관계
    // 객체지향적으로 연관관계를 주기 위해 ManyToOne 사용
    @ManyToOne(optional = false) //optional false는 필수값이다 의미
    private Article article;

    protected ArticleComment(){

    }
    private ArticleComment(String content, Article article) {
        this.content = content;
        this.article = article;
    }

    public static ArticleComment of(String content, Article article){
        return new ArticleComment(content, article);
    }

}
