# Trabalho Final Spring - Integrantes:
Caio Cesar - RM344946

Diogo Martins - RM344796

Marcos Alencar Arruda - RM344803

Vinicius Rodrigues Tonha - RM344810

# Pré-requisitos
Banco de dados MySQL rodando na porta 3306 com o schema test configurado.
Ex.: jdbc:mysql://localhost:3306/test?serverTimezone=UTC

Como facilitador existe um docker-compose com a conexão correta do banco de dados e com a database test e senha root configurada. 

para inicializar o banco de dados basta utilizar o comando na raiz do projeto:
docker-compose up

Obs.: é necessário o docker e o docker compose configurado e instalado

documentação do docker server para linux: https://docs.docker.com/engine/install/ubuntu/

Docker Desktop para MacOsx: https://docs.docker.com/desktop/install/mac-install/

Documentação do docker compose:  https://docs.docker.com/compose/

# Rodar projeto
### 1 - Startar o servidor web.

O Diretório do projeto 'web' contém as DDL de criação dos Bancos necessários para a aplicação.

Primeiramente startar o servidor web dentro do diretório web com o comando abaixo:
./mvnw spring-boot:run

### 2 - Carga Inicial dos clientes

O Diretório batch contém o projeto que carrega o arquivo inicial de clientes. O arquivo de clientes está no sub diretório chamado files.

Caso seja necessário alterar qualquer dado de conexão ou localização do arquivo de clientes o caminho para o arquivo de configuração é o seguinte:
batch/src/main/resources/application.yaml
 
para carregar os clientes faça o start do projeto atráves do comando abaixo no diretório batch:

./mvnw spring-boot:run

# Executar testes
./mvnw test

# Documentação Swagger
OBS.: 
O arquivo de clientes deve ser carregado imediatamente após startar o servidor web.
Caso tenha sido feito algum cadastro de clientes ou compras uma nova carga do arquivo vai reiniciar os bancos.

# 3 - Gerar Extrato
/api/alunos/{id}/fatura

# 4 -  Documentação Swagger
http://localhost:8080/swagger-ui/index.html

https://www.baeldung.com/spring-rest-openapi-documentation


# 5 - Justificativas técnicas
O Banco de dados escolhido foi o MySQL. Um banco de dados relacional possui a vantagem de persistência de dados
e desvantagem de possuir maior latência, porém por se tratar de transações de cartão de crédito
um banco de dados relacional é mais seguro para uma melhor garantia de consistência de dados.