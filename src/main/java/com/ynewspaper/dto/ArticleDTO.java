package com.ynewspaper.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDate publicationDate;
    private String category;
    private UserDTO user;
    private Long userId;
    
}
