package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.ErrorQueue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ErrorQueueMapper {
    /*
    public record ErrorQueue(Long id, Long categoryId, Long errorId, LocalDateTime createTime, LocalDateTime nextTime) {
    }
     */
    @Insert("INSERT INTO error_queue (category_id, error_id, create_time, next_time) VALUES (#{categoryId}, #{errorId}, #{createTime}, #{nextTime})")
    void insertErrorQueue(ErrorQueue errorQueue);
    @Delete("DELETE FROM error_queue WHERE error_id = #{errorId}")
    void deleteErrorQueueByErrorId(Long errorId);
    @Update("UPDATE error_queue SET category_id = #{categoryId}, error_id = #{errorId}, create_time = #{createTime}, next_time = #{nextTime} WHERE id = #{id}")
    void updateErrorQueue(ErrorQueue errorQueue);
    @Select("SELECT * FROM error_queue")
    List<ErrorQueue> selectErrorQueue();
    @Select("SELECT * FROM error_queue WHERE category_id = #{categoryId}")
    List<ErrorQueue> selectErrorQueueByCategoryId(Long categoryId);
}
