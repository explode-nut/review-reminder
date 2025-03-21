package com.czn.reviewreminder.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DatabaseInitMapper {
    @Update("CREATE TABLE IF NOT EXISTS Category (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    name TEXT NOT NULL,\n" +
            "    is_delete INTEGER DEFAULT 0,\n" +
            "    create_time TEXT,\n" +
            "    update_time TEXT\n" +
            ");")
    void createCategoryTable();

    @Update("CREATE TABLE IF NOT EXISTS Error (\n" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    content TEXT NOT NULL,\n" +
            "    category_id INTEGER,\n" +
            "    create_time TEXT,\n" +
            "    update_time TEXT,\n" +
            "    FOREIGN KEY (category_id) REFERENCES Category(id)\n" +
            ");")
    void createErrorTable();
}
