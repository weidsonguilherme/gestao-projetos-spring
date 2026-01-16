# 🚀 Sistema de Gestão de Projetos e Tarefas

API REST desenvolvida para gerenciamento de projetos e suas respectivas tarefas, focando em boas práticas de arquitetura e manipulação de dados com Spring Boot.

## 🛠️ Tecnologias Utilizadas
- **Java 25** e **Spring Boot 4**
- **Spring Data JPA**: Persistência de dados simplificada.
- **H2 Database**: Banco de dados em memória para testes rápidos.
- **Lombok**: Redução de código boilerplate (Getters/Setters).
- **Postman**: Testes e validação das rotas da API.

## 📌 Funcionalidades
- [x] **Projetos**: Criar, listar, buscar por nome e excluir.
- [x] **Tarefas**: Criar tarefas vinculadas a um projeto específico.
- [x] **Relacionamentos**: Implementação de `@OneToMany` com tratamento de recursividade JSON.
- [x] **Busca Dinâmica**: Filtro de projetos via Query Params (`?nome=...`).

## 🛣️ Como testar as rotas
### Projetos
- `GET /projetos`: Lista todos os projetos.
- `POST /projetos`: Cria um novo projeto.
- `DELETE /projetos/{id}`: Remove um projeto.

### Tarefas
- `POST /tarefas`: Cria uma tarefa vinculada a um `projeto_id`.

---
Desenvolvido por [Weidson Guilherme] durante estudos de Backend com Spring Boot.
