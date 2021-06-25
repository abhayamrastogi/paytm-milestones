# paytm-milestones

An example of user CRUD implementation with Spring Boot

# Foreword

This application is designed to follow SOLID principles, especially the Dependency Inversion Principle.

Concretely, there are 3 main packages: ```model```, ```service``` and ```controller```. These packages have to respect these rules:

- ```model``` responsible to interact with persistence stores. Basically model is an entity for a springboot application.
- ```service``` responsible to handle business logic. A layer between controller layer and persistence layer.
- ```controller``` responsible for processing incoming REST API requests, preparing a model & returing a response.

# Dependencies
- ```spring-boot-starter-web```
- ```spring-boot-starter-data-jpa```
- ```mysql-connector-java```

# Install

mvn clean install


# Run
 mvn spring-boot:run
