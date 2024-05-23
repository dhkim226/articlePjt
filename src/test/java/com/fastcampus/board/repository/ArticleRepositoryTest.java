package com.fastcampus.board.repository;

import com.fastcampus.board.config.JPAConfig;
import com.fastcampus.board.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("JPA 연결 테스트")
@Import(JPAConfig.class)
@DataJpaTest
class ArticleRepositoryTest {
    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public ArticleRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository
    ){
        this.articleCommentRepository = articleCommentRepository;
        this.articleRepository = articleRepository;
    }

    @DisplayName("select Test")
    @Test
    void givenTestData_whenSelecting_thenWorkisFine(){
        // Given
        // When
        List<Article> articles = articleRepository.findAll();
        // then
        assertThat(articles)
                .isNotNull()
                .hasSize(0);
    }
}