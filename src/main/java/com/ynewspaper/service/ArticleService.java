package com.ynewspaper.service;

import java.util.List;
import java.util.Optional;
import com.ynewspaper.entity.Article;
import com.ynewspaper.repository.ArticleRepository;


public interface ArticleService {
    
Article createArticle(ArticleService articleService);
    
    public static final ArticleRepository articleRepository = null;

    // Actualizar un artículo existente
    public default Article updateArticle(Long id, Article updatedArticle) {
        Optional<Article> existingArticleOpt = articleRepository.findById(id);

        if (existingArticleOpt.isEmpty()) {
            throw new RuntimeException("Artículo con ID " + id + " no encontrado");
        }

        Article existingArticle = existingArticleOpt.get();

    // Actualiza solo los campos que tengan datos válidos
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

    // Eliminar un artículo por ID (con manejo de errores dentro del service)
    public default String deleteArticle(Long id) {
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

    List<Article> getAllArticles();

    Article getArticleById(Long id);

    Article createArticle(Article article);
}


/*package com.ynewspaper.service;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;

public interface ArticleService {

    ArticleDTO createArticle(ArticleDTO dto);

    Article updateArticle(Long id, Article updatedArticle);

    void deleteArticle(Long id);
}*/
