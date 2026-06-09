package com.example.githublearning.todo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final AtomicLong sequence = new AtomicLong(2);
    private final ConcurrentMap<Long, Todo> todos = new ConcurrentHashMap<>();

    public TodoService() {
        Instant now = Instant.now();
        todos.put(1L, new Todo(1L, "Create first GitHub issue", false, now, now));
        todos.put(2L, new Todo(2L, "Open a pull request", false, now, now));
    }

    public List<Todo> findAll() {
        List<Todo> result = new ArrayList<>(todos.values());
        result.sort(Comparator.comparingLong(Todo::id));
        return result;
    }

    public Todo create(TodoCreateRequest request) {
        long id = sequence.incrementAndGet();
        Instant now = Instant.now();
        Todo todo = new Todo(id, request.title(), false, now, now);
        todos.put(id, todo);
        return todo;
    }

    public Todo update(long id, TodoUpdateRequest request) {
        Todo existing = todos.get(id);
        if (existing == null) {
            throw new TodoNotFoundException(id);
        }

        Todo updated = new Todo(id, request.title(), request.completed(), existing.createdAt(), Instant.now());
        todos.put(id, updated);
        return updated;
    }

    public void delete(long id) {
        Todo removed = todos.remove(id);
        if (removed == null) {
            throw new TodoNotFoundException(id);
        }
    }
}

