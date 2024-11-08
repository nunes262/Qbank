*Banco Online - Projeto Acadêmico*

Este projeto simula um sistema de banco digital desenvolvido em Java com o framework Micronaut, como parte de um trabalho acadêmico. Ele oferece funcionalidades bancárias básicas, como criação de contas, consultas de saldo, transferências e histórico de transações, aplicando conhecimentos em Java, APIs REST, persistência de dados e boas práticas de desenvolvimento.

Funcionalidades Principais
- Criar Conta: Permite ao usuário cadastrar uma nova conta bancária.
- Consultar Saldo: Permite visualizar o saldo atual de uma conta.
- Transferências: Facilita a realização de transferências entre contas registradas no sistema.
- Histórico de Transações: Exibe o histórico de todas as transações da conta, incluindo depósitos, saques e transferências.
  
Tecnologias Utilizadas
Java: Linguagem principal do projeto.
Micronaut: Framework leve para criação de microserviços, conhecido por sua inicialização rápida, baixo uso de memória e fácil integração com Java.
Banco de Dados (H2/MySQL): Utilizado para persistência de dados, configurado para uso com H2 (em memória) durante o desenvolvimento e com MySQL em produção.
Maven: Ferramenta de build usada para gerenciar dependências e compilar o projeto.
Arquitetura do Projeto
O projeto foi estruturado em camadas para facilitar a manutenção e separação de responsabilidades:

Controller: Define os endpoints da API REST que permitem interagir com as funcionalidades do banco.
Service: Contém a lógica de negócios, como regras de transações, validações e operações bancárias.
Repository: Responsável pela persistência e recuperação de dados no banco de dados.
Pré-requisitos
Para executar o projeto, você precisará:

Java 11 ou superior
Micronaut CLI (opcional, para comandos adicionais do Micronaut)
Maven (para compilar e executar o projeto)
MySQL (se desejar usar um banco de dados externo; configure as credenciais no arquivo application.yml)
Instruções de Instalação e Execução
Clone o Repositório:


git clone https://github.com/gabrielcouto07/Qbank
cd seu-repositorio
Configuração do Banco de Dados:

O projeto vem configurado com H2 como banco de dados padrão.
Para utilizar MySQL, altere as configurações em src/main/resources/application.yml para inserir suas credenciais de banco.
Compilar o Projeto com Maven:


mvn clean install
Executar a Aplicação:

mvn mn:run
Acessar a API:

A aplicação estará disponível em http://localhost:8080.
