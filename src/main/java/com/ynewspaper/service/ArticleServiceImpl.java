/*package com.ynewspaper.service;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;
import com.ynewspaper.entity.User;
import com.ynewspaper.repository.ArticleRepository;
import com.ynewspaper.repository.UserRepository;
import com.ynewspaper.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, 
                            UserRepository userRepository,
                            ArticleMapper articleMapper) {
                                        this.articleRepository = articleRepository;
                                        this.userRepository = userRepository;
                                        this.articleMapper = articleMapper;
                            }

    @Override
    public ArticleDTO createArticle(ArticleDTO dto) {
        User user = userRepository.findById(dto.getUserId())
        .orElseThrow(() -> new RuntimeException("User not found"));
        
        Article article = articleMapper.toEntity(dto, user);

        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDTO(savedArticle);

        }
}*/

package com.ynewspaper.service;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;
import com.ynewspaper.entity.User;
import com.ynewspaper.repository.ArticleRepository;
import com.ynewspaper.repository.UserRepository;
import com.ynewspaper.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository,
                              UserRepository userRepository,
                              ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public ArticleDTO createArticle(ArticleDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Article article = articleMapper.toEntity(dto, user);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDTO(savedArticle);
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
    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Artículo con ID " + id + " no encontrado");
        }
        articleRepository.deleteById(id);
    }
}


