# URL-shortener :rocket:
## Description
This is a backend service for shortening URLs and managing access statistics, developed using Java and Spring Boot. It allows you to shorten long links, redirect to original URLs, and view statistics such as total accesses and average accesses per day. This project was developed as part of a technical test for TDS Company.

## Requirements
- Java 11 or higher
- Maven
- MySQL database
- Git

## Cloning the Repository
To clone the repository, use the command:

```bash
git clone https://github.com/your-username/url-shortener.git
```
Make sure you have Java and Maven properly configured in your development environment.

## Running the Application
### Compile and Execute
To compile and run the application, navigate to the project directory and execute:

```bash
mvn clean install
mvn spring-boot:run
```

### Database
Make sure to create a database named url-shortener and adjust the application.properties file for your username and password.

## Accessing the API
Once the server is running, you can access the API routes at http://localhost:8080 (using Insomnia or Postman).

## Testing
Unit tests have been implemented to ensure code quality and robustness. You can run all tests using Maven:

```bash
mvn test
```
This includes tests for the main functionalities of the service.

## Features
The URL shortener service includes the following functionalities:
- Register URL: Accepts a URL and returns a shortened version.
- Access shortened URL: Redirects to the original URL using the shortened version.
- View statistics: Displays the total accesses and average accesses per day for a shortened URL.

## Example Endpoints
- **POST /api/v1/urls/create** - Registers a new URL and returns the shortened version.
- **GET /api/v1/urls/{shortenedUrl}** - Redirects to the original URL using the shortened version.
- **GET /api/v1/urls/stats/{shortenedUrl}** - Displays access statistics.

## Technologies Used
- Java 17
- Spring Boot
- Maven
- MySQL database
- JUnit and Mockito

## License
This project is licensed under the MIT License - see the LICENSE file for more details.

# Encurtador de URLs :rocket:
## Descrição
Este é um serviço backend para encurtar URLs e gerenciar estatísticas de acesso, desenvolvido utilizando Java e Spring Boot. Ele permite encurtar links longos, redirecionar para URLs originais e visualizar estatísticas como o total de acessos e a média de acessos por dia. Este projeto foi desenvolvido como parte de um teste técnico para a TDS Company.

## Requisitos
- Java 11 ou superior
- Maven
- Banco de dados MySQL
- Git

## Clonando o Repositório
Para clonar o repositório, utilize o comando:

```bash
git clone https://github.com/seu-usuario/encurtador-de-urls.git
```
Certifique-se de ter o Java e o Maven configurados corretamente no seu ambiente de desenvolvimento.

## Como Rodar
### Compilar e Executar
Para compilar e rodar a aplicação, navegue até o diretório do projeto e execute:

```bash
mvn clean install
mvn spring-boot:run
```

### Banco de Dados
Certifique-se de criar um Banco de dados nomeado url-shortener e adapte no application.properties para seu nome de usuário e senha 

## Acessando a API
Uma vez que o servidor esteja rodando, você pode acessar as rotas da API em http://localhost:8080. (pelo insomnia ou postman)

## Como Testar
Testes unitários   foram implementados para garantir a qualidade e a robustez do código. Você pode rodar todos os testes usando o Maven:

```bash
mvn test
```
Isso inclui testes para as principais funcionalidades do serviço.

## Funcionalidades
O serviço de encurtador de URLs inclui as seguintes funcionalidades:

- Cadastrar URL: Recebe uma URL e retorna uma versão encurtada.
- Acessar URL encurtada: Redireciona para a URL original usando a versão encurtada.
- Visualizar estatísticas: Exibe o total de acessos e a média de acessos por dia para uma URL encurtada.
  
## Exemplos de Endpoints
- **POST /api/v1/urls/create** - Cadastra uma nova URL e retorna a versão encurtada.
- **GET /api/v1/urls/{shortenedUrl}** - Redireciona para a URL original usando a versão encurtada.
- **GET /api/v1/urls/stats/{shortenedUrl}** - Exibe estatísticas de acessos.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Maven
- Banco de dados MySQL
- JUnit e Mockito

## Licença
Este projeto é licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.
