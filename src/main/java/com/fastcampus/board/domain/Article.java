package com.fastcampus.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long article_id;

    @Column
    private String title;

    @Column
    @Setter
    private String comment;

    @Column
    private String hashtag;

    @Column
    @CreatedDate
    private OffsetDateTime createdAt;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedDate
    private OffsetDateTime modifiedAt;

    @Column
    @LastModifiedBy
    private String modifiedBy;

    @ToString.Exclude
    @OrderBy("article_id")
    @OneToMany(mappedBy = "article")
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    private Article(String title, String comment, String hashtag) {
        this.title = title;
        this.comment = comment;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String comment, String hashtag){
        return new Article(title, comment, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return article_id == article.article_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_id);
    }
}
