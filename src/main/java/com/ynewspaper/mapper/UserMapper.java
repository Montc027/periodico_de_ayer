package com.ynewspaper.mapper;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "articles", ignore = true)
    User toEntity(UserDTO userDTO);
}

