package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Article;

import com.fastcampus.board.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article> // 기본 검색기능 그치만 정확하게 단어가 일치해야 검색이 된다.
        ,QuerydslBinderCustomizer<QArticle> //
{
    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy);
//        bindings.bind(root.title).first((StringExpression::likeIgnoreCase)); // like '${v}' -> %를 수동으로 사용여부 선택
        bindings.bind(root.title).first((StringExpression::containsIgnoreCase)); // like '%${v}%' -> %가 포함된 검색
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase)); // like '%${v}%' -> %가 포함된 검색
        bindings.bind(root.hashtag).first((StringExpression::containsIgnoreCase)); // like '%${v}%' -> %가 포함된 검색
        bindings.bind(root.createdAt).first((DateTimeExpression::eq));
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));
    }
}