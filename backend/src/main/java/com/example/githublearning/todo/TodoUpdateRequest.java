package com.example.githublearning.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TodoUpdateRequest(
        @NotBlank
        @Size(max = 120)
        String title,
        boolean completed
) {
}

