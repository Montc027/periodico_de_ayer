# 📰 Periódico de Ayer  
API REST para crear, leer, actualizar y borrar artículos de opinión **sin registro**.  
Basta con proporcionar **nombre** y **correo electrónico**.

## 🧱 Stack
| Tecnología | Versión |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.3.5 |
| PostgreSQL | 15+ |
| MapStruct | 1.5.5.Final |
| Lombok | 1.18.30 |
| Maven | 3.9+ |

## 🚀 Primeros pasos
1. **Clonar**
   ```bash
   git clone https://github.com/Montc027/periodico_de_ayer.git

| Método   | Endpoint             | Uso                       |
| -------- | -------------------- | ------------------------- |
| `POST`   | `/api/users`         | Crear usuario             |
| `GET`    | `/api/users/{id}`    | Ver usuario con artículos |
| `POST`   | `/api/articles`      | Publicar artículo         |
| `GET`    | `/api/articles`      | Listar todos              |
| `GET`    | `/api/articles/{id}` | Ver artículo              |
| `PUT`    | `/api/articles/{id}` | Actualizar                |
| `DELETE` | `/api/articles/{id}` | Borrar                    |

{
  "title": "El futuro de Java",
  "content": "Desde Java 21 tenemos virtual threads, pattern matching...",
  "category": "Tecnología",
  "userId": 1
}

## ✅ Business rules
Title 1-255 chars, non-empty.
Content 50-2000 chars.
One user → many articles.
Cascade delete on user.
No auth required.

## 🧪 Testing
bash
common.copy
mvn test              # unit tests
mvn verify            # integration tests

## 📁 Architecture
common.copy
controller  → REST layer
service     → business logic
repository  → Spring Data JPA
entity      → JPA models
dto         → transfer objects
mapper      → MapStruct
exception   → global handler

##👩‍💻 Authors
Stef PO
Lu SM
Montse Dev
Sofi Dev


