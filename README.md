# Java Microservices Project with Eureka, Spring Cloud Config, and H2 Database

## Project Overview
This project is a microservices architecture built using:
- **Eureka Server** for service discovery
- **Spring Cloud Config Server** for centralized configuration
- **Spring Cloud Client** to retrieve configurations
- **H2 Database** as an in-memory database

The project consists of the following services:
1. **Config Server** - Centralized configuration stored in a GitHub repository.
2. **Service Main** - The main service that fetches configurations from the Config Server.
3. **Service One** - A microservice that depends on Service Main.
4. **Service Notification** - A notification service that also depends on Service Main.

## Project Structure
```
config-microservice-centralized/  # Configuration stored in GitHub repo
service.main/                     # Main service (Eureka Server)
service-one/                      # Dependent microservice
service.notification/              # Notification service
```

## Prerequisites
Ensure you have the following installed:
- JDK 17+
- Maven
- Docker (Optional, if running in containers)

## Running the Project

### 1. Start the Config Server
The configuration files are stored in a GitHub repository:
[config-microservice-centralized](https://github.com/GabrielNunes12/config-microservice-centralized)

Ensure that `service.main`, `service.one`, and `service.notification` fetch their configurations from this repository.

### 2. Run **Service Main** (Eureka Server)
Navigate to the `service.main` directory and run:
```sh
mvn spring-boot:run
```
This will start the Eureka Server and retrieve configurations from the Config Server.

### 3. Run **Service One**
Navigate to the `service-one` directory and run:
```sh
mvn spring-boot:run
```
This service will register itself with the Eureka Server.

### 4. Run **Service Notification**
Navigate to the `service.notification` directory and run:
```sh
mvn spring-boot:run
```
This service will also register itself with the Eureka Server.

## Accessing the Services
- Eureka Dashboard: `http://localhost:8181`
- Service Main: `http://localhost:8181`
- Service One: `http://localhost:8881`
- Service Notification: `http://localhost:8082`

## Database
This project uses an in-memory **H2 database**.
To access the H2 console, navigate to:
```
http://localhost:8881/h2-console
```
Use the following credentials:
- **JDBC URL:** `jdbc:h2:mem:tasks`
- **Username:** `sa`
- **Password:** (leave blank)

## Conclusion
This setup ensures that all services fetch their configurations dynamically and register themselves with Eureka for service discovery. Modify the properties in the `config-microservice-centralized` repository to manage configurations centrally.

Enjoy building microservices with Spring Boot!

