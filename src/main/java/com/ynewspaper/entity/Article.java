package com.ynewspaper.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "articles")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Size(min = 50, max = 2000)
    @Column(length = 3000)
    private String content;

    private String category;
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
