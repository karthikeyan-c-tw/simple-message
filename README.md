## Simple Message

A Spring Boot application that provides greeting messages in multiple languages.

## Technologies & Frameworks

- **Java 22**
- **Spring Boot 3.5.3**
  - Spring Web MVC
  - Spring Data JPA
- **Lombok** - For reducing boilerplate code
- **H2 Database** - In-memory database
- **Gradle** - Build tool with Kotlin DSL

## Dependencies

- spring-boot-starter-data-jpa
- spring-boot-starter-web
- lombok
- h2 database

## Prerequisites

- JDK 22
- Gradle (build tool)

## Building the Application

To build the application, run:

``` bash
./gradlew build
```

## Running the Application

To start the application, run:


``` bash
./gradlew bootRun
```

The application will start on the port 7000.

## Features

- Multi-language greeting messages support
- RESTful API for retrieving greetings
- Persistent storage of greetings using JPA
- Support for 20 different languages including English, Spanish, French, Japanese, and more


## Database

The application uses H2 in-memory database with JPA for persistence. The database is pre-populated with greetings in multiple languages.

- [Schema](src/main/resources/schema.sql)
- [Data](src/main/resources/greetings.sql)