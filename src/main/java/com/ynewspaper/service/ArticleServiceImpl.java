package com.ynewspaper.service;

import com.ynewspaper.entity.Article;
import com.ynewspaper.entity.User;
import com.ynewspaper.repository.ArticleRepository;
import com.ynewspaper.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository,
            UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;

    }

    @Override
    public Article createArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException("Article must not be null");
        }

        Long userId = (article.getUser() != null) ? article.getUser().getId() : null;
        if (userId == null) {
            throw new IllegalArgumentException("Article must include a valid user id");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (article.getPublicationDate() == null) {
            article.setPublicationDate(LocalDate.now());
        }

        article.setUser(user);
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();

    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo con ID " + id + " no encontrado"));
    }

    @Override
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

    @Override
    public String deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo con ID " + id + " no encontrado"));

        articleRepository.delete(article);
        return "Artículo eliminado correctamente";
    }
}

/*
 * package com.ynewspaper.service;
 * 
 * import com.ynewspaper.dto.ArticleDTO;
 * import com.ynewspaper.entity.Article;
 * import com.ynewspaper.entity.User;
 * import com.ynewspaper.repository.ArticleRepository;
 * import com.ynewspaper.repository.UserRepository;
 * import com.ynewspaper.mapper.ArticleMapper;
 * import org.springframework.stereotype.Service;
 * 
 * import java.util.Optional;
 * 
 * @Service
 * public class ArticleServiceImpl implements ArticleService {
 * 
 * private final ArticleRepository articleRepository;
 * private final UserRepository userRepository;
 * private final ArticleMapper articleMapper;
 * 
 * 
 * public ArticleServiceImpl(ArticleRepository articleRepository,
 * UserRepository userRepository,
 * ArticleMapper articleMapper) {
 * this.articleRepository = articleRepository;
 * this.userRepository = userRepository;
 * this.articleMapper = articleMapper;
 * }
 * 
 * @Override
 * public ArticleDTO createArticle(ArticleDTO dto) {
 * User user = userRepository.findById(dto.getUserId())
 * .orElseThrow(() -> new RuntimeException("User not found"));
 * 
 * Article article = articleMapper.toEntity(dto, user);
 * Article savedArticle = articleRepository.save(article);
 * return articleMapper.toDTO(savedArticle);
 * }
 * 
 * 
 * }
 */