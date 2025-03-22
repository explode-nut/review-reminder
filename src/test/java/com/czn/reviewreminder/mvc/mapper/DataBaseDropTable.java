package com.czn.reviewreminder.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DataBaseDropTable {
    @Update("DROP TABLE IF EXISTS category")
    void dropCategoryTable();

    @Update("DROP TABLE IF EXISTS error")
    void dropErrorTable();

    @Update("DROP TABLE IF EXISTS tag")
    void dropTagTable();

    @Update("DROP TABLE IF EXISTS error_queue")
    void dropErrorQueueTable();
}
