package com.ynewspaper.repository;

import com.ynewspaper.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRespository extends JpaRepository<Article, Long> {
    List<Article> findByUserId(Long userId);
    List<Article> findByArticleId(String id);
}
