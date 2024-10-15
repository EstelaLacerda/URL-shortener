# URL-shortener
## Português:
API Rest para encurtamento de URLs com Java e Spring Boot. O projeto inclui redirecionamento para as URLs originais e estatísticas de acessos das URLs encurtadas. 

## Inglês:
Rest API for URL shortening using Java and Spring Boot. The project includes redirection to original URLs and access statistics for the shortened URLs.

# Encurtador de URLs
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
Copiar código
git clone https://github.com/seu-usuario/encurtador-de-urls.git
```
Certifique-se de ter o Java e o Maven configurados corretamente no seu ambiente de desenvolvimento.

## Como Rodar
### Compilar e Executar
Para compilar e rodar a aplicação, navegue até o diretório do projeto e execute:

bash
Copiar código
mvn clean install
mvn spring-boot:run

### Banco de Dados
Certifique-se de criar um Banco de dados nomeado url-shortener e adapte no application.properties para seu nome de usuário e senha 

## Acessando a API
Uma vez que o servidor esteja rodando, você pode acessar as rotas da API em http://localhost:8080. (pelo insomnia ou postman)

## Como Testar
Testes foram implementados para garantir a qualidade e a robustez do código. Você pode rodar todos os testes usando o Maven:

bash
Copiar código
mvn test
Isso inclui testes unitários e de integração para as principais funcionalidades do serviço.

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
