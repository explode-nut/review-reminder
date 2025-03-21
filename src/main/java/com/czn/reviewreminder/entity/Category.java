package com.czn.reviewreminder.entity;

import java.time.LocalDateTime;

public record Category(Long id, String name, Integer isDelete, LocalDateTime createTime, LocalDateTime updateTime) {
}
