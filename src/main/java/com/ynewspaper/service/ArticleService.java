/*package com.ynewspaper.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ynewspaper.entity.Article;
import com.ynewspaper.repository.ArticleRepository;
import com.ynewspaper.dto.ArticleDTO;


public interface ArticleService {
    
ArticleDTO createArticle(ArticleDTO dto);
    @Autowired
    private ArticleRepository articleRepository;

    // Actualizar un artículo existente
    public Article updateArticle(Long id, Article updatedArticle) {
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

    // Eliminar un artículo por ID
    public void deleteArticle(Long id) {
        Optional<Article> articleOpt = articleRepository.findById(id);

        if (articleOpt.isEmpty()) {
            throw new RuntimeException("Artículo con ID " + id + " no encontrado");
        }

        articleRepository.delete(articleOpt.get());
    }
}
*/

package com.ynewspaper.service;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;

public interface ArticleService {

    ArticleDTO createArticle(ArticleDTO dto);

    Article updateArticle(Long id, Article updatedArticle);

    void deleteArticle(Long id);
}
