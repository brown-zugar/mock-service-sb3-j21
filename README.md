# Mock Service - User Access Management

## Description

This project is a mock service for managing user access. It provides RESTful endpoints for user authentication and information retrieval. The service is built with Spring Boot 3 and uses an in-memory H2 database for storing user data.

## Technologies Used

*   **Java:** 21
*   **Spring Boot:** 3.5.6
*   **Database:** H2 (In-memory)
*   **Build Tool:** Maven

## How to Run

1.  **Prerequisites:**
    *   Java 21 or higher
    *   Maven 3.x

2.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```

3.  **Navigate to the project directory:**
    ```bash
    cd mock-service-sb3-j21
    ```

4.  **Build and run the application:**
    ```bash
    mvn spring-boot:run
    ```

The application will start on port 8080.

## API Endpoints

The following are the main endpoints exposed by the service:

*   **`POST /users/login`**: Authenticates a user.
    *   **Request Body:**
        ```json
        {
          "email": "user@example.com",
          "password": "password"
        }
        ```
    *   **Response:**
        *   `200 OK`: If authentication is successful, returns a JWT token.
        *   `401 Unauthorized`: If authentication fails.

*   **`GET /users/{id}`**: Retrieves user information by ID.
    *   **Response:**
        *   `200 OK`: Returns user details.
        *   `404 Not Found`: If the user is not found.

*   **`GET /users`**: Get the list of users.
    *   **Note:** This endpoint can only be accessed by users with the `ADMIN` role.
    *   **Response:**
        *   `200 OK`: Returns a list of all users.
        *   `403 Forbidden`: If the user does not have the `ADMIN` role.

## Project Structure

This project follows the principles of **Hexagonal Architecture** (also known as Ports and Adapters). This architectural style isolates the application's core logic from external concerns, making it more maintainable, testable, and independent of technologies and frameworks.

The project is structured into three main layers:

*   **Domain Layer (`src/main/java/com/tocode/application/domain`)**: This is the heart of the application. It contains the core business logic, entities (models), and ports (interfaces) that define how the application interacts with the outside world. It has no dependencies on any other layer.

*   **Application Layer (`src/main/java/com/tocode/application/adapters`)**: This layer orchestrates the application's use cases. It contains the application services (adapters) that implement the inbound ports defined in the domain layer. It depends on the domain layer but not on the infrastructure layer.

*   **Infrastructure Layer (`src/main/java/com/tocode/application/entrypoints` and `src/main/java/com/tocode/application/infraestructure`)**: This layer handles all external concerns, such as UI, databases, messaging queues, and third-party integrations. It contains the adapters that implement the outbound ports defined in the domain layer and the entry points (e.g., REST controllers) that interact with the application layer.

### Component Diagram

![Component Diagram](https://www.plantuml.com/plantuml/png/PP31JiCm44Jl_egb5qxj1t2e2fH39P0G4YVKWt6MOX6lL-iDKeJwxqGbh1BdcF7RcSdiYdhHBhNkIZyn8Np7T_6aph4FN_w4i7eWbPvp92qh-740zk8v_Ya0Rwy5vJuFQ6vRbECWdjrvudBRU5QKYyM8Zz9nQfayir4ZztJHbfRxd7oagbFA3RRJy_5mWd0MdH7FWx2WGax9KrECVCod0vdXhCc1FiGNbIve9rWrOfGIYteAE4jzGSubQfP-aLqmT1ArD_ukICzgmTUmHqPga4B4ukhnORtULXFFlc2pdI-xVBLPu0PYuXOJafOAj9ZfhomHQ-ziGpkszLrj19l_7aUtGsgwrFu2)