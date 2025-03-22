package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /*
    * public record Category(Long id, String name, LocalDateTime createTime, LocalDateTime updateTime) {
    * }
    * 使用mybatis对Category进行crud
    *
    * -- 创建 Category 表
CREATE TABLE IF NOT EXISTS category (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  create_time TEXT,
  update_time TEXT
);

-- 创建 Error 表
CREATE TABLE IF NOT EXISTS error (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  content TEXT NOT NULL,
  category_id INTEGER,
  rank INTEGER,
  create_time TEXT,
  update_time TEXT,
  FOREIGN KEY (categoryId) REFERENCES Category(id) ON DELETE CASCADE
);

-- 创建 Tag 表
CREATE TABLE IF NOT EXISTS tag (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  category_id INTEGER,
  error_id INTEGER,
  FOREIGN KEY (categoryId) REFERENCES Category(id) ON DELETE CASCADE,
  FOREIGN KEY (errorId) REFERENCES Error(id) ON DELETE CASCADE
);

-- 创建 ErrorQueue 表
CREATE TABLE IF NOT EXISTS error_queue (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  category_id INTEGER,
  error_id INTEGER,
  create_time TEXT,
  next_time TEXT,
  FOREIGN KEY (categoryId) REFERENCES Category(id) ON DELETE CASCADE,
  FOREIGN KEY (errorId) REFERENCES Error(id) ON DELETE CASCADE
);
    * */
    // 传入一个Category类作为参数，添加分类
    @Insert("INSERT INTO category (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void insertCategory(Category category);
    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteCategory(Long id);
    @Update("UPDATE category SET name = #{name}, create_time = #{createTime}, update_time = #{updateTime} WHERE id = #{id}")
    void updateCategory(Category category);
    @Select("SELECT * FROM category")
    List<Category> selectAllCategory();
    @Select("SELECT * FROM category WHERE id = #{id}")
    Category selectCategoryById(Long id);
}
