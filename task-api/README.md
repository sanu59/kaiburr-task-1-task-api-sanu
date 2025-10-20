# Kaiburr Task 1 – Spring Boot + MongoDB API

This project is a RESTful API built using **Spring Boot** and **MongoDB** for managing tasks.

## Features
- Create and update tasks  
- Retrieve tasks by ID or name  
- Delete tasks  
- Execute shell commands through a safe runner  

## Tech Stack
- **Java 17**  
- **Spring Boot 3**  
- **MongoDB**  
- **Maven**  
- **Postman** for testing APIs  

## Endpoints
| Method | Endpoint | Description |
|---------|-----------|-------------|
| `PUT` | `/api/tasks` | Create or update a task |
| `GET` | `/api/tasks` | Retrieve all tasks |
| `GET` | `/api/tasks?id=<id>` | Get task by ID |
| `GET` | `/api/tasks?name=<name>` | Get task by name |
| `DELETE` | `/api/tasks?id=<id>` | Delete a task |
| `GET` | `/api/tasks/execute?id=<id>` | Execute command for a task |

## Screenshots

Below are screenshots showing the working API for Kaiburr Task 1:

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


## How to Run
1. Ensure MongoDB is running on **localhost:27017**  
2. Run the app:
   ```bash
   mvn spring-boot:run
## Example Output
```json
{
  "id": "6701d9e4b3d8f25f1c8f184b",
  "name": "List Files",
  "owner": "Sanu",
  "command": "dir"
}


