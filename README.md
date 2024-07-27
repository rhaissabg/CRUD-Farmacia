# Projeto de Sistema de Farmácia com Spring Boot
Recentemente, desenvolvi um projeto inovador de um sistema para uma farmácia, utilizando o framework Spring Boot. Este sistema é projetado para gerenciar produtos e categorias de medicamentos, oferecendo funcionalidades completas de CRUD (Criar, Ler, Atualizar e Deletar).

## Objetivo do Projeto
O principal objetivo do projeto é fornecer uma solução eficiente para o gerenciamento de medicamentos e suas respectivas categorias em uma farmácia. O sistema permite a inserção, visualização, atualização e exclusão de informações sobre produtos e categorias, garantindo que os dados sejam organizados e facilmente acessíveis.

## Funcionalidades Implementadas
### 1. Gestão de Produtos:
* Criar: Adiciona novos produtos ao banco de dados com informações detalhadas, incluindo nome, fabricante, preço e quantidade em estoque.
* Ler: Permite a visualização de todos os produtos cadastrados, bem como a busca por produtos específicos.
* Atualizar: Permite a edição das informações dos produtos existentes, garantindo que os dados estejam sempre atualizados.
* Deletar: Remove produtos do sistema, com validação para garantir que a exclusão seja realizada de maneira segura.
  
### 2. Gestão de Categorias:
* Criar: Permite o cadastro de novas categorias, que podem ser associadas a diferentes tipos de medicamentos, como 'Antibióticos' ou 'Anti-hipertensivos'.
* Ler: Exibe a lista de categorias disponíveis, permitindo a filtragem e visualização de categorias específicas.
* Atualizar: Permite a modificação das descrições e nomes das categorias, garantindo que a categorização dos produtos seja precisa.
* Deletar: Facilita a exclusão de categorias, com a verificação de que não existam produtos associados antes da exclusão.
  
## Tecnologias Utilizadas
* Spring Boot: Utilizado para criar a aplicação com um fluxo de trabalho simplificado e robusto. O Spring Boot facilita a configuração e a implementação do projeto, além de fornecer suporte para operações
* CRUD com JPA (Java Persistence API).
* Spring Data JPA: Utilizado para a comunicação com o banco de dados, simplificando a persistência de dados e o gerenciamento das entidades.
* H2 Database: Uma base de dados em memória foi utilizada para desenvolvimento e testes, permitindo um ambiente de teste rápido e leve.
* JUnit: Para garantir a qualidade do código, foram implementados testes unitários utilizando JUnit. Esses testes cobrem as funcionalidades de CRUD, garantindo que todas as operações funcionem conforme o esperado.

## Como levantar o aplicativo

Para levantar o aplicativo, use este comando:
```shell
docker compose up -d
```

## Swagger

Swagger url: http://localhost:8080/swagger-ui/index.html

Api docs url: http://localhost:8080/v3/api-docs


## Conclusão
O sistema de farmácia desenvolvido é uma ferramenta poderosa para o gerenciamento eficiente de medicamentos e categorias. Com o uso de Spring Boot e outras tecnologias modernas, o projeto oferece uma solução completa e escalável para atender às necessidades de qualquer farmácia. Estou satisfeita com o resultado e confiante de que este sistema pode ser facilmente expandido para incluir funcionalidades adicionais no futuro.
