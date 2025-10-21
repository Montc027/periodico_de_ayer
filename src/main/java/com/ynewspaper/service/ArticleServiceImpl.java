package com.ynewspaper.service;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.mapper.ArticleMapper;
import com.ynewspaper.entity.Article;
import com.ynewspaper.entity.User;
import com.ynewspaper.repository.ArticleRepository;
import com.ynewspaper.repository.UserRepository;
import com.ynewspaper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, UserRepository userRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.articleMapper = articleMapper;

        Article article = articleMapper.toEntity(dto, user);
        return articleRepository.save(article);
}
}