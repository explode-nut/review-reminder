package com.czn.reviewreminder.entity;

import java.time.LocalDateTime;

public record Error(Long id, String content, Long categoryId, Integer rank, String createTime, String updateTime) {
}
