package com.ynewspaper.controller;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.ynewspaper.entity.Article;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@SuppressWarnings("unused")
@CrossOrigin(origins = "*")
public class ArticleController {

    
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
}

    @PostMapping
    public ArticleDTO createArticle(@RequestBody ArticleDTO dto) {
        return articleService.createArticle(dto);

    }
    

    private final ArticleService articleService;

    // Actualizar un artículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable Long id,
            @RequestBody Article updatedArticle) {
        Article article = articleService.updateArticle(id, updatedArticle);
        return ResponseEntity.ok(article);
    }

    // Eliminar un artículo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok("Article deleted successfully");
    }
}

