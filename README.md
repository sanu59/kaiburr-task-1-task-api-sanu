# Kaiburr Task 1 – Spring Boot + MongoDB API
This project is part of the Kaiburr Internship 2025 Assessment.  
It implements a RESTful API using **Spring Boot** and **MongoDB** for task management operations such as creating, updating, retrieving, and deleting tasks, as well as executing safe shell commands.

---

## Features
- Create and update tasks  
- Retrieve tasks by ID or name  
- Delete tasks  
- Execute shell commands through a safe runner  

---

## Tech Stack
- **Java 17**  
- **Spring Boot 3**  
- **MongoDB**  
- **Maven**  
- **Postman** for API testing  

---

## Endpoints

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `PUT` | `/api/tasks` | Create or update a task |
| `GET` | `/api/tasks` | Retrieve all tasks |
| `GET` | `/api/tasks?id=<id>` | Get task by ID |
| `GET` | `/api/tasks?name=<name>` | Get task by name |
| `DELETE` | `/api/tasks?id=<id>` | Delete a task |
| `GET` | `/api/tasks/execute?id=<id>` | Execute command for a task |

---

##  How to Run

1. Ensure MongoDB is running on **localhost:27017**  
2. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
## Example Output
{
  "id": "6701d9e4b3d8f25f1c8f184b",
  "name": "List Files",
  "owner": "Sanu",
  "command": "dir"
}

## Screenshots

Below are screenshots showcasing the successful execution of API endpoints for **Kaiburr Task 1**:

✅ **Spring Boot Console Log**  
![Spring Boot Console](screenshots/1-vscode-terminal.png)

✅ **POST /api/tasks – Create Task**  
![Postman PUT](screenshots/2-put-task.png)

✅ **GET /api/tasks – Retrieve All Tasks**  
![Postman GET All](screenshots/3-get-all.png)

✅ **GET /api/tasks?id={id} – Retrieve by ID**  
![Postman GET by ID](screenshots/4-get-by-id.png)

✅ **GET /api/tasks/search?name={name} – Search Success**  
![Search Success](screenshots/5-search-success.png)

✅ **GET /api/tasks/search?name={name} – 404 Not Found**  
![Search 404](screenshots/6-search-404.png)

✅ **PUT /api/tasks/{id}/execute – Execute Command**  
![Execute Command](screenshots/7-execute.png)

✅ **MongoDB Compass – Task Stored with Execution Data**  
![MongoDB Compass](screenshots/8-compass.png)

✅ **DELETE /api/tasks/{id} – 204 Success**  
![Delete 204](screenshots/9-delete-204.png)

✅ **GET /api/tasks/{id} – 404 After Deletion**  
![Delete 404](screenshots/10-delete-404.png)

---

 **Author:** Sangamithra B  
 Final Year B.Tech | Amrita Vishwa Vidyapeetham, Coimbatore  
 Completed for Kaiburr Internship Task 1 – October 2025
