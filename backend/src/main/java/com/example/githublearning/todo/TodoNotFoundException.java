package com.example.githublearning.todo;

public class TodoNotFoundException extends RuntimeException {

    TodoNotFoundException(long id) {
        super("Todo not found: " + id);
    }
}

