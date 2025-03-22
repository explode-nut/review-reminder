package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.Category;
import com.czn.reviewreminder.util.TimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    DatabaseInitMapper databaseInitMapper;
    @Autowired
    DataBaseDropTable dataBaseDropTable;

    // 测试category的增删改查
    @Test
    void testCrud() {
        System.out.println("=============================CategoryMapperTest:testCrud=============================");
        databaseInitMapper.createCategoryTable();
        String now = TimeFormatter.formatTime(LocalDateTime.now());
        Category category = new Category(null, "category1", now, now);
        Category category1 = new Category(null, "category2", now, now);
        Category category2 = new Category(null, "category3", now, now);
        categoryMapper.insertCategory(category);
        categoryMapper.insertCategory(category1);
        categoryMapper.insertCategory(category2);
        List<Category> categoryList = categoryMapper.selectAllCategory();
        Assertions.assertEquals(3, categoryList.size());
        categoryMapper.deleteCategory(1L);
        categoryList = categoryMapper.selectAllCategory();
        Assertions.assertEquals(2, categoryList.size());
        String now1 = TimeFormatter.formatTime(LocalDateTime.now());
        categoryMapper.updateCategory(new Category(2L, "category-modified", now1, now1));
        Category category3 = categoryMapper.selectCategoryById(2L);
        Assertions.assertEquals("category-modified", category3.name());
        categoryMapper.deleteCategory(2L);
        categoryMapper.deleteCategory(3L);
        dataBaseDropTable.dropCategoryTable();
    }
}
