package com.ynewspaper.mapper;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);
}

