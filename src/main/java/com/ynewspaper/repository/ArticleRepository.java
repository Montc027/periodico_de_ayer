package com.ynewspaper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ynewspaper.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
