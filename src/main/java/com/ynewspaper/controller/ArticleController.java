package com.ynewspaper.controller;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")

public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
}

    @PostMapping
    public ArticleDTO createArticle(@RequestBody ArticleDTO dto) {
        return articleService.createArticle(dto);
       
    }
}

