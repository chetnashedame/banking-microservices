# AI Coding Agent Instructions for `banking-microservices`

## Overview
This repository implements a microservices-based architecture for a banking system. It includes the following major components:

1. **Account Service**: Manages user accounts.
2. **Transaction Service**: Handles financial transactions.
3. **API Gateway**: Acts as a single entry point for client requests, routing them to the appropriate services.
4. **Service Registry**: Enables service discovery for dynamic routing between microservices.

Each service is implemented as a Spring Boot application with its own `Dockerfile` and `application.yaml` configuration.

## Key Developer Workflows

### Building and Running Services
- Use the provided `docker-compose.yml` to build and run all services together:
  ```bash
  docker-compose up --build
  ```
- To build and run a specific service, navigate to the service directory (e.g., `account-service`) and use Maven:
  ```bash
  ./mvnw clean package
  java -jar target/<service-name>-0.0.1-SNAPSHOT.jar
  ```

### Testing
- Unit and integration tests are located under `src/test/java` in each service.
- Run tests for a specific service using Maven:
  ```bash
  ./mvnw test
  ```

### Debugging
- Use the `application.yaml` files to configure logging levels for debugging.
- Services expose management endpoints (e.g., `/actuator`) for health checks and metrics.

## Project-Specific Conventions

### Configuration
- Each service has its own `application.yaml` file under `src/main/resources`.
- Common configurations (e.g., database URLs, service ports) are defined here.

### Communication
- Services communicate via REST APIs.
- The API Gateway routes requests to the appropriate service based on URL paths.
- Service discovery is managed by the Service Registry (e.g., Eureka).

### Code Structure
- Java packages follow the convention `com.bank.<service_name>`.
- Example: `com.bank.account_service` for the Account Service.

### Dockerization
- Each service has a `Dockerfile` for containerization.
- Ensure the `target` directory contains the built JAR file before building the Docker image.

## Integration Points
- **Database**: Each service connects to its own database instance (configured in `application.yaml`).
- **Service Registry**: All services register themselves with the Service Registry for dynamic discovery.
- **API Gateway**: Routes client requests to the appropriate microservice.

## Examples

### Adding a New Endpoint
1. Define the endpoint in the appropriate controller class (e.g., `AccountController`).
2. Update the `application.yaml` if new configurations are required.
3. Write unit tests under `src/test/java`.

### Updating Docker Images
1. Build the service JAR file:
   ```bash
   ./mvnw clean package
   ```
2. Build the Docker image:
   ```bash
   docker build -t <service-name>:<tag> .
   ```
3. Push the image to the container registry if needed.

---

For further details, refer to the `HELP.md` files in each service directory.