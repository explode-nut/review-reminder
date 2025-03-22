package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.Category;
import com.czn.reviewreminder.entity.Error;
import com.czn.reviewreminder.util.TimeFormatter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ErrorMapperTest {
    @Autowired
    private ErrorMapper errorMapper;
    @Autowired
    DatabaseInitMapper databaseInitMapper;
    @Autowired
    DataBaseDropTable dataBaseDropTable;

    @Test
    void testCrud() {
        System.out.println("=============================ErrorMapperTest:testCrud=============================");
        databaseInitMapper.createErrorTable();
        String now = TimeFormatter.formatTime(LocalDateTime.now());
        Error error = new Error(null, "test", 1L, 1, now, now);
        Error error1 = new Error(null, "test", 1L, 1, now, now);
        Error error2 = new Error(null, "test", 2L, 1, now, now);
        errorMapper.insertError(error);
        errorMapper.insertError(error1);
        errorMapper.insertError(error2);
        List<Error> errorList = errorMapper.selectAllError();
        Assertions.assertEquals(3, errorList.size());
        errorMapper.deleteError(1L);
        List<Error> errorList1 = errorMapper.selectAllError();
        Assertions.assertEquals(2, errorList1.size());
        String now1 = TimeFormatter.formatTime(LocalDateTime.now());
        errorMapper.updateError(new Error(2L, "test", 1L, 2, now1, now1));
        List<Error> errorList2 = errorMapper.selectErrorByCategoryId(1L);
        Assertions.assertEquals(1, errorList2.size());
        Assertions.assertEquals(2L, errorList2.getFirst().id());
        errorMapper.deleteError(2L);
        errorMapper.deleteError(3L);
        dataBaseDropTable.dropErrorTable();
    }
}
