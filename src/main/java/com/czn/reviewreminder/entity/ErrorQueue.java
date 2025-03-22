package com.czn.reviewreminder.entity;

import java.time.LocalDateTime;

public record ErrorQueue(Long id, Long categoryId, Long errorId, String createTime, String nextTime) {
}
