package com.czn.reviewreminder.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DatabaseInitMapper {
    @Update("CREATE TABLE IF NOT EXISTS category (\n" +
            "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  name TEXT NOT NULL,\n" +
            "  create_time TEXT,\n" +
            "  update_time TEXT\n" +
            ");")
    void createCategoryTable();

    @Update("CREATE TABLE IF NOT EXISTS error (\n" +
            "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  content TEXT NOT NULL,\n" +
            "  category_id INTEGER,\n" +
            "  rank INTEGER,\n" +
            "  create_time TEXT,\n" +
            "  update_time TEXT,\n" +
            "  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE\n" +
            ");")
    void createErrorTable();

    @Update("CREATE TABLE IF NOT EXISTS tag (\n" +
            "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  name TEXT NOT NULL,\n" +
            "  category_id INTEGER,\n" +
            "  error_id INTEGER,\n" +
            "  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE,\n" +
            "  FOREIGN KEY (error_id) REFERENCES error(id) ON DELETE CASCADE\n" +
            ");")
    void createTagTable();

    @Update("CREATE TABLE IF NOT EXISTS error_queue (\n" +
            "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  category_id INTEGER,\n" +
            "  error_id INTEGER,\n" +
            "  create_time TEXT,\n" +
            "  next_time TEXT,\n" +
            "  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE,\n" +
            "  FOREIGN KEY (error_id) REFERENCES error(id) ON DELETE CASCADE\n" +
            ");")
    void createErrorQueueTable();
}
