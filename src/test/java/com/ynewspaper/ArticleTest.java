package com.ynewspaper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ynewspaper.entity.Article;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

    private Article article;
    private Validator validator;

    @BeforeEach
    void setUp() {
        // Inicializamos el validador de anotaciones (@NotBlank, @Size, etc.)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        // Creamos un artículo válido por defecto
        article = new Article();
        article.setId(1L);
        article.setTitle("Título de ejemplo");
        article.setContent("Contenido de ejemplo con más de cincuenta caracteres para pasar la validación.");
        article.setCategory("Noticias");
        article.setPublicationDate(LocalDate.now());
    }

    @Test
    void testArticleFieldsNotNull() {
        assertNotNull(article.getTitle());
        assertNotNull(article.getContent());
        assertNotNull(article.getCategory());
        assertNotNull(article.getPublicationDate());
    }

    @Test
    void testValidArticleShouldPassValidation() {
        Set<ConstraintViolation<Article>> violations = validator.validate(article);
        assertTrue(violations.isEmpty(), "El artículo válido no debería tener errores de validación");
    }

    @Test
    void testBlankTitleShouldFailValidation() {
        article.setTitle(" ");
        Set<ConstraintViolation<Article>> violations = validator.validate(article);
        assertFalse(violations.isEmpty(), "El título en blanco debería fallar la validación");
    }

    @Test
    void testShortContentShouldFailValidation() {
        article.setContent("Muy corto");
        Set<ConstraintViolation<Article>> violations = validator.validate(article);
        assertFalse(violations.isEmpty(), "El contenido demasiado corto debería fallar la validación");
    }

    @Test
    void testSettersAndGetters() {
        Article a = new Article();
        a.setId(2L);
        a.setTitle("Nuevo título");
        a.setContent("Contenido con al menos cincuenta caracteres para que sea válido y pase la validación.");
        a.setCategory("Deportes");
        a.setPublicationDate(LocalDateTime.of(2025, 1, 1, 10, 30));

        assertEquals(2L, a.getId());
        assertEquals("Nuevo título", a.getTitle());
        assertEquals("Deportes", a.getCategory());
        assertEquals(LocalDateTime.of(2025, 1, 1, 10, 30), a.getPublicationDate());
    }
}