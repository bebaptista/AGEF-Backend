# Aplicativo de Gerenciamento de Estoque e Faturamento

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

API REST construída utilizando [Spring Boot](http://projects.spring.io/spring-boot/) como requisito para aprovação na disciplina `Trabalho Interdisciplinar de Software V`.

## Requisitos

Para compilar e executar a aplicação você precisa de:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Executando a aplicação localmente

Existem várias formas de executar uma aplicação do Spring Boot na sua máquina local. Uma forma é executando o método `main` na classe `com.tis.agef.Application` a partir da sua IDE.

Alternativamente você pode usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html):

```shell
mvn spring-boot:run
```

## Estrutura de pastas


```bash
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.tis.agef
│   │   │       ├── configurations
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── SwaggerConfig.java
│   │   │       │      
│   │   │       ├── domains
│   │   │       │   ├── Defeito.java
│   │   │       │   ├── Modelo.java
│   │   │       │   ├── PecaFeira.java
│   │   │       │   └── Venda.java
│   │   │       │      
│   │   │       ├── repositories
│   │   │       │   ├── custom
│   │   │       │   │   └── PecaFeiraRepositoryCustom.java
│   │   │       │   │   
│   │   │       │   ├── impl
│   │   │       │   │   └── PecaFeiraRepositoryImpl.java
│   │   │       │   │                 
│   │   │       │   ├── DefeitoRepository.java
│   │   │       │   ├── ModeloRepository.java
│   │   │       │   ├── PecaFeiraRepository.java
│   │   │       │   └── VendaRepository.java
│   │   │       │ 
│   │   │       │      
│   │   │       ├── resources
│   │   │       │   ├── helpers
│   │   │       │   │   └── ExceptionMessages.java
│   │   │       │   │                 
│   │   │       │   ├── DefeitoResource.java
│   │   │       │   ├── ModeloResource.java
│   │   │       │   ├── PecaFeiraResource.java
│   │   │       │   └── VendaResource.java
│   │   │       │      
│   │   │       ├── services
│   │   │       │   ├── exceptions
│   │   │       │   │   └── ObjectNotFoundException.java
│   │   │       │   │                 
│   │   │       │   ├── DefeitoService.java
│   │   │       │   ├── ModeloService.java
│   │   │       │   ├── PecaFeiraService.java
│   │   │       │   └── VendaService.java
│   │   │       │ 
│   │   │       └── Application.java
│   │   │
│   │   └── resources
│   │       ├── http-requests-collection
│   │       │   ├── defeito-requests.http
│   │       │   ├── modelo-requests.http
│   │       │   ├── pecafeira-requests.http
│   │       │   └── venda-requests.http
│   │       │
│   │       ├── application.properties
│   │       └── banner.txt
│   │
│   └── test
│       └── com.tisv.agef
│           └── Tests.java
│   
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── .gitignore
```

## Copyright

Disponibilizada sob a Apache License 2.0. Consulte o arquivo de [LICENÇA](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE).
