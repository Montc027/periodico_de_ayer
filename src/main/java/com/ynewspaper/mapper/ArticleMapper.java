package com.ynewspaper.mapper;

import com.ynewspaper.dto.ArticleDTO;
import com.ynewspaper.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target = "id", ignore = true)
    Article toEntity(ArticleDTO dto, com.ynewspaper.entity.User user);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "user", source = "user")
    ArticleDTO toDTO(com.ynewspaper.entity.Article article);

    }   