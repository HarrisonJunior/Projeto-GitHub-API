<h1 align="center">Projeto-GitHub-API</h1>

<p align="center">Este projeto realiza acesso à dados da <a href="https://docs.github.com/pt/rest"> API GitHub </a></p>

## Status

<h4 align="center"> 
	🚧  Projeto 🚀 em desenvolvimento...  🚧
</h4>


<p align="center">
 <a href="#Status">Status</a> •
 <a href="#Features">Features</a> • 
 <a href="#Pré-requisitos">Pré-requisitos</a> •  
 <a href="#Rodando-servidor-e-executando-projeto">Rodando-servidor-e-executando-projeto</a> •
 <a href="#Tecnologias">Tecnologias</a> •
 <a href="#Autor">Autor</a>
</p>

## Features

- [x] Consulta à nomes de todos os repositórios de uma organização
- [x] Consulta à Contribuidores presentes em todos repositórios de uma organização
- [x] Consulta à Contribuições de Contribuidores de uma organização


## Pré-requisitos

Antes de começar, é necessário ter um token OAuth de acesso ào GitHub:
Em seguida, crie uma variável de ambiente chamada GH_TOKEN e adicione o token ao seu valor.
De preferência, utilize a IDE InteliJ IDEA por questões de suporte ao SBT.


## Rodando-servidor-e-executando-projeto

```bash
# Clone este repositório
$ git clone https://github.com/HarrisonJunior/Projeto-GitHub-API.git

# Importe o seu projeto para a sua IDE

# Inicie o servidor e a execute a aplicação:
$ Caso esteja utilizando o InteliJ, acesse o terminal sbt e execute o comando run
$ Caso esteja utilizando o terminal cmd, acesse o diretório do projeto e execute o comando sbt run

# O servidor inciará na porta:9000 - acesse <http://localhost:9000/api/v1/organizations/[nome-da-organização]/contributors passando> o nome da organização neste link
```

## Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Java 8](https://docs.oracle.com/javase/8/docs)
- [Play Framework 2.8.8](https://www.playframework.com/documentation/2.8.8/Home)
- [sbt 1.5](https://www.scala-sbt.org/1.x/docs)
- [InteliJ IDEA 2020.1.2 (Community Edition)](https://www.jetbrains.com/pt-br/idea)

## Autor

Harrison Júnior

https://www.linkedin.com/in/harrison-j%C3%BAnior-13230b137 harrison.junior@hotmail.com
