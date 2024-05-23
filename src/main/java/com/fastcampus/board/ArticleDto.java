package com.fastcampus.board;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.fastcampus.board.domain.Article}
 */
public record ArticleDto(
        String title,
        String comment,
        String hashtag,
        OffsetDateTime createdAt,
        String createdBy,
        OffsetDateTime modifiedAt,
        String modifiedBy
) implements Serializable {
}