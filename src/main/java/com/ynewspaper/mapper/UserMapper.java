package com.ynewspaper.mapper;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ArticleMapper.class})
public interface UserMapper {

    @Mapping(target = "articles", source = "articles")
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}

