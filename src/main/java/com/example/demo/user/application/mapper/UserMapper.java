package com.example.demo.user.application.mapper;

import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToDomain(UserEntity userEntity);

    UserEntity mapToEntity(User user);
}
