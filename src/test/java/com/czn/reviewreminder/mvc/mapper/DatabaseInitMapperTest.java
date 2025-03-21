package com.czn.reviewreminder.mvc.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;

@SpringBootTest
@ActiveProfiles("test")
@Log4j
public class DatabaseInitMapperTest {
    @Autowired
    DatabaseInitMapper databaseInitMapper;

    @Test
    void testCreateTable() {
        databaseInitMapper.createCategoryTable();
        databaseInitMapper.createErrorTable();
        File dbFile = new File("test.db");
        Assertions.assertTrue(dbFile.exists());
    }
}
