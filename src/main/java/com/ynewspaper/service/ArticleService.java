package com.ynewspaper.service;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;
public interface ArticleService {
    Article createArticle(ArticleDTO dto);
}
