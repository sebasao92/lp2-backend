package com.example.demo.user.domain;

import com.example.demo.user.application.mapper.UserMapper;
import com.example.demo.user.infrastructure.repository.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class User {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    @NotBlank(message = "Last name cannot be null or empty")
    private String lastName;

    @NotBlank(message = "Photo URL cannot be null or empty")
    private String photoUrl;

    @NotNull(message = "Type cannot be null")
    private UserType type;

    public UserEntity toEntity() {
        return UserMapper.INSTANCE.mapToEntity(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", type=" + type +
                '}';
    }
}
