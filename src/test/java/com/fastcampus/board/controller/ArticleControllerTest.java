package com.fastcampus.board.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)  // 테스트 대상인 controller만 bean으로 불러오기 가능.
@WithMockUser(username = "user", roles = {"USER"})
class ArticleControllerTest {
    private final MockMvc mvc;
    // 생성자 주입 방식으로 하겠다

    public ArticleControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }
    @DisplayName("[view][GET] 게시글 리스트 (게시판) 페이저 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticlesView_thenReturnsArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));  // 이 view는 게시글의 목록이 떠야하는데 이것은 서버에서 넘겨준것이다. 이 Key를 가진 data가 있는지 까지 확인하는 것

    }

    @DisplayName("[view][GET] 게시글 단건 (게시판) 페이저 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticleView_thenReturnsArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));  // 이 view는 게시글의 목록이 떠야하는데 이것은 서버에서 넘겨준것이다. 이 Key를 가진 data가 있는지 까지 확인하는 것

    }

    @DisplayName("[view][GET] 게시글 검색전용 페이저 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticleSearchView_thenReturnsArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

    @DisplayName("[view][GET] 게시글 해시태그 페이저 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticleSearchHashtagView_thenReturnsArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
}