# Trabalho Final Spring - Integrantes:
Caio Cesar - RM344946

Diogo Martins - RM344796

Marcos Alencar Arruda - RM344803

Vinicius Rodrigues Tonha - RM344810

# Pré-requisitos
Banco de dados MySQL rodando na porta 3306 
Ex.: jdbc:mysql://localhost:3306/test?serverTimezone=UTC

# Rodar projeto
### 1 - Startar o servidor web.

O Diretório do projeto 'web' contém as DDL de criação dos Bancos necessários para a aplicação.

Primeiramente startar o servidor web dentro do diretório web com o comando abaixo:
./mvnw spring-boot:run

### 2 - Carga Inicial dos clientes

O Diretório batch contém o projeto que carrega o arquivo inicial de clientes. 
para carregar os clientes faça o start do projeto atráves do comando abaixo no diretório batch:

./mvnw spring-boot:run

OBS.: 
O arquivo de clientes deve ser carregado imediatamente após startar o servidor web.
Caso tenha sido feito algum cadastro de clientes ou compras uma nova carga do arquivo vai reiniciar os bancos.

# 3 -  Documentação Swagger
http://localhost:8080/swagger-ui/index.html

https://www.baeldung.com/spring-rest-openapi-documentation


# 4 - Justificativas técnicas
O Banco de dados escolhido foi o MySQL. Um banco de dados relacional possui a vantagem de persistência de dados
e desvantagem de possuir maior latência, porém por se tratar de transações de cartão de crédito
um banco de dados relacional é mais seguro para uma melhor garantia de consistência de dados.