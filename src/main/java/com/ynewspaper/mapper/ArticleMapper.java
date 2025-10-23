package com.ynewspaper.mapper;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;
import com.ynewspaper.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.ynewspaper.mapper.ArticleMapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    Article toEntity(ArticleDTO dto, User user);

    @Mapping(target = "userId", source = "user.id")
    ArticleDTO toDTO(Article article);
}
