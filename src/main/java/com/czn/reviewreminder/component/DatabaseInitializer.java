package com.czn.reviewreminder.component;

import com.czn.reviewreminder.mvc.mapper.DatabaseInitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    DatabaseInitMapper databaseInitMapper;

    @Override
    public void run(String... args) throws Exception {
        databaseInitMapper.createCategoryTable();
        databaseInitMapper.createErrorTable();
        System.out.println("初始化数据库表成功！");
    }
}
