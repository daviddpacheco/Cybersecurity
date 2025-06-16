🛡️ AlertaBet – Serviço Nacional para Monitoramento de Apostas
👨‍💻 Membros do Grupo
David de Medeiros – RM: 551462

Orlando Akio – RM: 98067

Pedro Henrique Guariente – RM: 550301

📌 Visão Geral
AlertaBet é um sistema backend desenvolvido com arquitetura orientada a serviços (SOA), projetado para lidar com o crescente problema de comportamento compulsivo em plataformas de apostas online no Brasil. O sistema simula um serviço de autenticação e gestão de usuários, oferecendo endpoints RESTful organizados em camadas e documentados com Swagger/OpenAPI.

🎯 Objetivo do Projeto
Demonstrar a aplicação de uma arquitetura orientada a serviços com Java 17 e Spring Boot 3+.

Implementar uma API RESTful com endpoints de cadastro, autenticação e gerenciamento de usuários.

Utilizar práticas como DTO, Repository, Service e Controller para separação de responsabilidades.

Prover documentação interativa via Swagger.

Adotar um modelo de segurança com Spring Security e simulação de token de autenticação.

🚀 Funcionalidades Implementadas
✅ Endpoints REST
POST /api/v1/usuarios – Criação de novo usuário

GET /api/v1/usuarios – Listagem de usuários

PUT /api/v1/usuarios/{id} – Atualização de usuário

DELETE /api/v1/usuarios/{id} – Exclusão de usuário

POST /auth/login – Autenticação de usuário com email e senha

POST /api/v1/usuarios/auth/login – Autenticação alternativa

🔐 Segurança
Spring Security configurado para permitir todas as requisições (foco na arquitetura e autenticação fake).

Endpoint /auth/login retorna um token simulado ("fake-jwt-token").

Login validado por email e senha padrão armazenada em memória (banco H2).

📑 Documentação com Swagger
A aplicação está totalmente documentada com Swagger/OpenAPI, permitindo visualização e teste dos endpoints via navegador:

🔗 Acesse: http://localhost:8080/swagger-ui/index.html

Exemplos de tela (evidência de funcionamento):
🔑 Login com token:
![image](https://github.com/user-attachments/assets/50ad4e8b-6703-4fff-8d3f-a8a27fe9273f)


📄 Interface Swagger com endpoints:
![image](https://github.com/user-attachments/assets/18f964de-a0b2-4016-a67c-8b8a4656a1d5)



👤 Cadastro de usuário:
![image](https://github.com/user-attachments/assets/b504a3b2-442b-4ddc-881c-ab766a556912)


📘 Tecnologias Utilizadas
Java 17

Spring Boot 3.5.0

Spring Web, Spring Security, Spring Data JPA

H2 Database (em memória)

Swagger/OpenAPI (via Springdoc 2.1.0)

📦 Padrões Aplicados
DTO (Data Transfer Object)

Repository (JPA)

Service Layer

Controller Layer

Tratamento básico de erros

Arquitetura orientada a serviços (SOA)

📁 Documentação da API
A documentação foi gerada automaticamente com base nos métodos REST. As rotas foram organizadas por recursos, e o retorno de dados é padronizado em formato JSON, com validação automática e testes realizados diretamente via Swagger.

