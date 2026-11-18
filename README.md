# 📝 Task Management REST API

Welcome! This is a simple, beginner-friendly Spring Boot backend application that lets you manage a list of tasks using standard HTTP methods (CRUD operations). 

It stores tasks temporarily in memory using a Java `ArrayList` (no database required yet!).

---

## 🚀 API Endpoints Overview

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/task` | Get a list of all tasks |
| **GET** | `/task/{id}` | Get a specific task by its ID |
| **POST** | `/task` | Create and add a new task |
| **PUT** | `/task/{id}` | Update an existing task by ID |
| **DELETE** | `/task/{id}` | Delete a task by its ID |

---

## 🛠️ Code Breakdown for Beginners

* **`@RestController`**: Tells Spring Boot that this class will handle incoming web requests and return data directly (usually as JSON).
* **`@RequestMapping("/task")`**: Sets the base URL path for all methods in this controller. Every endpoint will start with `/task`.
* **`ResponseEntity`**: Used in some methods to send back specific HTTP status codes (like `200 OK`, `204 No Content`, or `404 Not Found`) along with your data.

---

## 💡 How to Test It
You can run this Spring Boot application from your IDE (like IntelliJ or Eclipse) and test the endpoints using tools like **Postman**, **cURL**, or your browser (for GET requests).
