# 👋 About

Prices API Rest project based on layered architecture.

## ⚙️ Requirements

- JDK 11.
- Maven 3.8.4

## 📘 Technologies

### Common

I've built this project following a typical layered architecture (controller, service and repository). I've added a `GlobalExceptionHandler` to manage exceptions and possible errors within the API

### H2 adapter

| Technology | Purpose |
| ---------- |----------|
| [H2Database](https://www.h2database.com/html/main.html) | Very fast, open source, JDBC API. Support embedded and server modes; disk-based or in-memory databases |
| [Spring Data JPA](https://spring.io/projects/spring-data-jpa) | JPA based repositories implementation |
| [Flyway](https://flywaydb.org/) | To load database migrations at application startup. |

### REST adapter

| Technology | Purpose |
| ---------- |----------|
| [springdoc-openapi-ui](https://springdoc.org/) | Helps to automate the generation of API documentation using spring boot projects. |
| [rest-assured](https://rest-assured.io/) | Testing and validating REST services |

## 🚀 How to execute the application

Go to the project root directory and execute the following command to compile, test, package and install the different artifacts in your local maven repository.

```shell
mvn clean install
```

Or use the embedded maven wrapper if you don't have a maven installation.

```shell
./mvnw clean install
```

After creating all artifacts you can run the project with the following command:

```shell
mvn spring-boot:run
```

Or use the embedded maven wrapper if you don't have a maven installation.

```shell
./mvnw spring-boot:run
```

It means the application is running properly and it will provide the following endpoints:

- `http://localhost:8080/api/prices`. GET http method that will receive three parameters.
- `http://localhost:8080/v3/api-docs`. OpenAPI schema auto-generated from the swagger annotation provided by the `springdoc` dependency.
- `http://localhost:8080/swagger-ui.html`. Swagger interface based on the OpenAPI auto-generated schema that helps you to test the `prices` resource endpoint.
