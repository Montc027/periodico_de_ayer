package com.ynewspaper;

import com.ynewspaper.service.ArticleService;

import com.ynewspaper.entity.Article;
import com.ynewspaper.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArticleServiceTest<articleService> {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    private Article article;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        article = new Article();
        article.setId(1L);
        article.setTitle("Título original");
        article.setContent("Contenido original con más de 50 caracteres de ejemplo para test.");
        article.setCategory("Noticias");
        article.setPublicationDate(LocalDate.now());
    }

    @Test
    void testGetAllArticles() {
        when(articleRepository.findAll()).thenReturn(List.of(article));

        List<Article> result = articleService.getAllArticles();

        assertEquals(1, result.size());
        verify(articleRepository, times(1)).findAll();
    }

    @Test
    void testGetArticleByIdFound() {
        when(articleRepository.findById(1L)).thenReturn(Optional.of(article));

        Article result = articleService.getArticleById(1L);

        assertEquals("Título original", result.getTitle());
        verify(articleRepository, times(1)).findById(1L);
    }

    @Test
    void testGetArticleByIdNotFound() {
        when(articleRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            articleService.getArticleById(1L);
        });

        assertTrue(exception.getMessage().contains("no encontrado"));
    }

    @Test
    void testUpdateArticle() {
        Article updated = new Article();
        updated.setTitle("Nuevo título");
        updated.setContent("Nuevo contenido con más de 50 caracteres para validación.");
        updated.setCategory("Deportes");

        when(articleRepository.findById(1L)).thenReturn(Optional.of(article));
        when(articleRepository.save(any(Article.class))).thenReturn(updated);

        Article result = articleService.updateArticle(1L, updated);

        assertEquals("Nuevo título", result.getTitle());
        verify(articleRepository, times(1)).save(any(Article.class));
    }

    @Test
    void testDeleteArticleFound() {
        when(articleRepository.findById(1L)).thenReturn(Optional.of(article));

        String result = articleService.deleteArticle(1L);

        assertTrue(result.contains("eliminado correctamente"));
        verify(articleRepository, times(1)).delete(article);
    }

    @Test
    void testDeleteArticleNotFound() {
        when(articleRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> articleService.deleteArticle(1L));
    }
}
