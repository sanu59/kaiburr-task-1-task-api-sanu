package com.kaiburr.taskapi.controller;

import com.kaiburr.taskapi.model.Task;
import com.kaiburr.taskapi.model.TaskExecution;
import com.kaiburr.taskapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<?> getTasks(@RequestParam(value = "id", required = false) String id) {
        if (id == null || id.isBlank()) return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.findByIdOr404(id));
    }

    @PutMapping
    public ResponseEntity<Task> putTask(@Valid @RequestBody Task task) {
        Task saved = service.upsert(task);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> search(@RequestParam("name") String name) {
        List<Task> found = service.findByNameContains(name);
        if (found.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(found);
    }

    @PutMapping("/{id}/execute")
    public ResponseEntity<TaskExecution> execute(@PathVariable String id) throws Exception {
        TaskExecution exec = service.execute(id);
        return ResponseEntity.ok(exec);
    }
}
