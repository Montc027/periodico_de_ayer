package com.ynewspaper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynewspaper.entity.Article;
import com.ynewspaper.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // Listar todos los artículos
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Actualizar un artículo existente
    public Article updateArticle(Long id, Article updatedArticle) {
        Optional<Article> existingArticleOpt = articleRepository.findById(id);

        if (existingArticleOpt.isEmpty()) {
            throw new RuntimeException("Artículo con ID " + id + " no encontrado");
        }

        Article existingArticle = existingArticleOpt.get();

        if (updatedArticle.getTitle() != null && !updatedArticle.getTitle().isBlank()) {
            existingArticle.setTitle(updatedArticle.getTitle());
        }

        if (updatedArticle.getContent() != null && updatedArticle.getContent().length() >= 50) {
            existingArticle.setContent(updatedArticle.getContent());
        }

        if (updatedArticle.getCategory() != null && !updatedArticle.getCategory().isBlank()) {
            existingArticle.setCategory(updatedArticle.getCategory());
        }

        if (updatedArticle.getPublicationDate() != null) {
            existingArticle.setPublicationDate(updatedArticle.getPublicationDate());
        }

        return articleRepository.save(existingArticle);
    }

    // Eliminar un artículo por ID
    public String deleteArticle(Long id) {
        Optional<Article> articleOpt = articleRepository.findById(id);

        if (articleOpt.isEmpty()) {
            throw new RuntimeException("Artículo con ID " + id + " no encontrado");
        }

        try {
            articleRepository.delete(articleOpt.get());
            return "Artículo con ID " + id + " eliminado correctamente.";
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el artículo con ID " + id + ": " + e.getMessage());
        }
    }
}
