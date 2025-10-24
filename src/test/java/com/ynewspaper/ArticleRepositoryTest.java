package com.ynewspaper;

import com.ynewspaper.entity.Article;
import com.ynewspaper.repository.ArticleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
 public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testSaveAndFindArticle() {
        Article article = new Article();
        article.setTitle("Título H2");
        article.setContent("Contenido H2 con más de 50 caracteres para validación y persistencia.");
        article.setCategory("Pruebas");
        article.setPublicationDate(LocalDateTime.now());

        Article saved = articleRepository.save(article);
        assertNotNull(saved.getId());

        List<Article> all = articleRepository.findAll();
        assertFalse(all.isEmpty());
    }
}