package com.ynewspaper.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") // Nombre de la tabla en la base de datos
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    // Si quieres, puedes agregar relación inversa con Article
    // @OneToMany(mappedBy = "user")
    // private List<Article> articles;
}
