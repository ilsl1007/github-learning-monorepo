package com.example.githublearning.todo;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/todos")
    List<Todo> findAll() {
        return todoService.findAll();
    }

    @PostMapping("/api/todos")
    @ResponseStatus(HttpStatus.CREATED)
    Todo create(@Valid @RequestBody TodoCreateRequest request) {
        return todoService.create(request);
    }

    @PutMapping("/api/todos/{id}")
    Todo update(@PathVariable long id, @Valid @RequestBody TodoUpdateRequest request) {
        return todoService.update(id, request);
    }

    @DeleteMapping("/api/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable long id) {
        todoService.delete(id);
    }

    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse handleNotFound(TodoNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    record ErrorResponse(String message) {
    }
}

