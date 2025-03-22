package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class TagMapperTest {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    DatabaseInitMapper databaseInitMapper;
    @Autowired
    DataBaseDropTable dataBaseDropTable;

    @Test
    void testCrud() {
        System.out.println("=============================TagMapperTest:testCrud=============================");
        databaseInitMapper.createTagTable();
        tagMapper.insertTag(new Tag(null, "test", 1L, 1L));
        tagMapper.insertTag(new Tag(null, "test", 1L, 2L));
        tagMapper.insertTag(new Tag(null, "test", 2L, 1L));
        List<Tag> tagList = tagMapper.selectTag();
        Assertions.assertEquals(3, tagList.size());
        tagMapper.deleteTag(1L);
        tagList = tagMapper.selectTag();
        Assertions.assertEquals(2, tagList.size());
        tagMapper.updateTag(new Tag(2L, "test-modified", 1L, 2L));
        tagList = tagMapper.selectTag();
        Assertions.assertEquals("test-modified", tagList.getFirst().name());
        tagMapper.deleteTag(2L);
        tagMapper.deleteTag(3L);
        dataBaseDropTable.dropTagTable();
    }
}
