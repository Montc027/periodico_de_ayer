package com.ynewspaper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.ynewspaper.controller.ArticleController;
import com.ynewspaper.entity.Article;
import com.ynewspaper.service.ArticleService;

public class ArticleControllerTest {

    @Test
    void testName() {
        
    }

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    private Article article1;
    private Article article2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        article1 = new Article();
        article1.setId(1L);
        article1.setTitle("Primer artículo");
        article1.setContent("Contenido del primer artículo con más de 50 caracteres para cumplir la validación.");
        article1.setCategory("Noticias");
        article1.setPublicationDate(LocalDate.now());

        article2 = new Article();
        article2.setId(2L);
        article2.setTitle("Segundo artículo");
        article2.setContent("Contenido del segundo artículo con más de 50 caracteres para cumplir la validación.");
        article2.setCategory("Deportes");
        article2.setPublicationDate(LocalDate.now());
    }

    @SuppressWarnings("null")
    @Test
    void testGetAllArticles() {
        List<Article> articles = Arrays.asList(article1, article2);
        when(articleService.getAllArticles()).thenReturn(articles);

        ResponseEntity<List<Article>> response = articleController.getAllArticles();

        assertEquals(2, response.getBody().size());
        verify(articleService, times(1)).getAllArticles();
    }

    @SuppressWarnings("null")
    @Test
    void testGetArticleById() {
        when(articleService.getArticleById(1L)).thenReturn(article1);

        ResponseEntity<Article> response = articleController.getArticleById(1L);

        assertEquals("Primer artículo", response.getBody().getTitle());
        verify(articleService, times(1)).getArticleById(1L);
    }

    @SuppressWarnings("null")
    @Test
    void testUpdateArticle() {
        Article updatedArticle = new Article();
        updatedArticle.setTitle("Artículo actualizado");
        updatedArticle.setContent("Contenido actualizado con más de 50 caracteres para pasar la validación.");

        when(articleService.updateArticle(1L, updatedArticle)).thenReturn(updatedArticle);

        ResponseEntity<Article> response = articleController.updateArticle(1L, updatedArticle);

        assertEquals("Artículo actualizado", response.getBody().getTitle());
        verify(articleService, times(1)).updateArticle(1L, updatedArticle);
    }

    @Test
    void testDeleteArticle() {
        when(articleService.deleteArticle(1L)).thenReturn("Artículo con ID 1 eliminado correctamente.");

        ResponseEntity<String> response = articleController.deleteArticle(1L);

        assertEquals("Artículo con ID 1 eliminado correctamente.", response.getBody());
        verify(articleService, times(1)).deleteArticle(1L);
    }
}
