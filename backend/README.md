# Practice Spring Modulith Project

This project demonstrates a modular monolith architecture using Spring Boot and Spring Modulith.

## Features
- Product and Notification domain modules
- REST API endpoints for creating and listing products and notifications
- Event-driven communication between modules
- Example HTTP tests in `api-tests.http`

## Getting Started

### Prerequisites
- Java 24+
- Gradle

### Build and Run
```sh
./gradlew clean build
./gradlew bootRun
```

### API Endpoints
- `POST /api/products` — Create a new product
- `GET /api/products` — List all products
- `POST /api/notifications` — Create a new notification

### Testing the API
Use the provided `api-tests.http` file with VS Code's REST Client extension or any HTTP client.

## Project Structure
```
src/main/java/works/lionel/practice/
  product/
    controller/ProductController.java
    ProductService.java
    ProductDTO.java
  notification/
    controller/NotificationController.java
    NotificationService.java
    NotificationDTO.java
```

## License
MIT
