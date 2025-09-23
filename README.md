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
