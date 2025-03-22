package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.ErrorQueue;
import com.czn.reviewreminder.util.TimeFormatter;
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
public class ErrorQueueMapperTest {
    @Autowired
    private ErrorQueueMapper errorQueueMapper;
    @Autowired
    DatabaseInitMapper databaseInitMapper;
    @Autowired
    DataBaseDropTable dataBaseDropTable;

    @Test
    void testCrud() {
        System.out.println("=============================ErrorQueueMapperTest:testCrud=============================");
        databaseInitMapper.createErrorQueueTable();
        String now = TimeFormatter.formatTime(LocalDateTime.now());
        errorQueueMapper.insertErrorQueue(new ErrorQueue(null, 1L, 1L, now, now));
        errorQueueMapper.insertErrorQueue(new ErrorQueue(null, 1L, 2L, now, now));
        errorQueueMapper.insertErrorQueue(new ErrorQueue(null, 2L, 1L, now, now));
        List<ErrorQueue> errorQueues = errorQueueMapper.selectErrorQueue();
        Assertions.assertEquals(3, errorQueues.size());
        errorQueueMapper.deleteErrorQueueByErrorId(2L);
        errorQueues = errorQueueMapper.selectErrorQueue();
        Assertions.assertEquals(2, errorQueues.size());
        String now1 = TimeFormatter.formatTime(LocalDateTime.now());
        errorQueueMapper.updateErrorQueue(new ErrorQueue(1L, 2L, 1L, now1, now1));
        errorQueues = errorQueueMapper.selectErrorQueue();
        Assertions.assertEquals(now1, errorQueues.get(1).nextTime());
        errorQueueMapper.deleteErrorQueueByErrorId(1L);
        dataBaseDropTable.dropErrorQueueTable();
    }
}
