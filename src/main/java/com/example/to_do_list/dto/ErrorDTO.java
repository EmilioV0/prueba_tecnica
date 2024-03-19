package com.example.to_do_list.dto;

import java.time.LocalDateTime;

public record ErrorDTO(
    LocalDateTime timestamp,
    String message,
    String path
) {
}
