package com.kaiburr.taskapi.service;

import com.kaiburr.taskapi.model.Task;
import com.kaiburr.taskapi.model.TaskExecution;
import com.kaiburr.taskapi.repo.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {
    private final TaskRepository repo;
    private final CommandValidator validator;
    private final CommandRunner runner;

    public TaskService(TaskRepository repo, CommandValidator validator, CommandRunner runner) {
        this.repo = repo;
        this.validator = validator;
        this.runner = runner;
    }

    public List<Task> findAll() { return repo.findAll(); }

    public Task findByIdOr404(String id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found: " + id));
    }

    public Task upsert(Task task) {
        if (!StringUtils.hasText(task.getId())) task.setId(null);
        validator.ensureSafe(task.getCommand());
        return repo.save(task);
    }

    public void delete(String id) {
        if (!repo.existsById(id)) throw new NoSuchElementException("Task not found: " + id);
        repo.deleteById(id);
    }

    public List<Task> findByNameContains(String namePart) {
        String regex = ".*" + java.util.regex.Pattern.quote(namePart) + ".*";
        return repo.findByNameRegex("(?i)" + regex);
    }

    public TaskExecution execute(String id) throws Exception {
        Task task = findByIdOr404(id);
        validator.ensureSafe(task.getCommand());
        Instant start = Instant.now();
        String out = runner.run(task.getCommand());
        Instant end = Instant.now();
        TaskExecution exec = new TaskExecution(start, end, out);
        task.getTaskExecutions().add(exec);
        repo.save(task);
        return exec;
    }
}
