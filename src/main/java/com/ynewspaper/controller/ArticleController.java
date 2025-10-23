package com.ynewspaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ynewspaper.entity.Article;
import com.ynewspaper.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //  Listar todos los artículos
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

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
        String message = articleService.deleteArticle(id);
        return ResponseEntity.ok(message);
    }
}
