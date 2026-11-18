# 📝 Task Management REST API (Layered Architecture)

Welcome! This is a clean, beginner-friendly Spring Boot application that manages tasks using standard CRUD operations. 

It improves upon basic controllers by separating the **web layer** (`TaskController`) from the **business logic** (`TaskService`)—a core best practice in Spring Boot!

---

## 🏗️ Project Architecture

Instead of doing everything inside one file, the app is split into two main parts:

1. **`TaskController` (The Receptionist):** Handles incoming HTTP requests, validates URLs/data, and sends back proper HTTP status codes.
2. **`TaskService` (The Worker):** Holds the task list in memory (`ArrayList`) and performs the actual adding, finding, updating, and deleting.

---

## 🚀 API Endpoints

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/task` | Get a list of all tasks |
| **GET** | `/task/{id}` | Get a specific task by its ID |
| **POST** | `/task` | Create and add a new task |
| **PUT** | `/task/{id}` | Update an existing task by ID |
| **DELETE** | `/task/{id}` | Delete a task by its ID |

---

## 🛠️ Key Spring Concepts Used

* **`@RestController` & `@RequestMapping("/task")`**: Exposes the class as a web API where every route starts with `/task`.
* **`@Service`**: Marks `TaskService` as a business-logic component so Spring can manage it automatically.
* **Constructor Injection (`final` field)**: `TaskController` receives `TaskService` through its constructor. Using `final` ensures the dependency cannot be changed or left empty.
* **`ResponseEntity`**: Controls exact HTTP responses like `200 OK`, `204 No Content`, and `404 Not Found`.

---

## 💡 How to Test It
Run the application from your IDE (IntelliJ, Eclipse, or VS Code) and test the endpoints using **Postman**, **cURL**, or your browser (for `GET` requests).
