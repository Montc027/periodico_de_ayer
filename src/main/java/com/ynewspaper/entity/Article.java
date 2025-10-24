package com.ynewspaper.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Data
@Entity
@Table(name = "articles")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Size(min = 50, max = 2000)
    @Column(length = 3000)
    private String content;

    private String category;
    private LocalDate publicationDate;
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    
}
