package com.ynewspaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class YnewspaperApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                              .directory(".")
                              .ignoreIfMalformed()
                              .ignoreIfMissing()
                              .load();

        System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
        System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
        System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
        System.setProperty("spring.datasource.driver-class-name", "org.postgresql.Driver");

        SpringApplication.run(YnewspaperApplication.class, args);

        System.out.println("Conexión exitosa a PostgreSQL: " + dotenv.get("DB_URL"));
    }
}
