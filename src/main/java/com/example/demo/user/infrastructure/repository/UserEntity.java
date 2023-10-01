package com.example.demo.user.infrastructure.repository;

import com.example.demo.user.application.mapper.UserMapper;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    public User toDomain() {
        return UserMapper.INSTANCE.mapToDomain(this);
    }
}
