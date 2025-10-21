package com.ynewspaper.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "articles")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate publicationDate;
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
}
