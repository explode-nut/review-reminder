package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.Error;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ErrorMapper {
    /*
    public record Error(Long id, String content, Long categoryId, Integer rank, LocalDateTime createTime, LocalDateTime updateTime) {
    }对Error进行crud
     */
    @Insert("INSERT INTO error (content, category_id, rank, create_time, update_time) VALUES (#{content}, #{categoryId}, #{rank}, #{createTime}, #{updateTime})")
    void insertError(Error error);
    @Delete("DELETE FROM error WHERE id = #{id}")
    void deleteError(Long id);
    @Update("UPDATE error SET content = #{content}, category_id = #{categoryId}, rank = #{rank}, update_time = #{updateTime} WHERE id = #{id}")
    void updateError(Error error);
    // 根据categoryId查询error
    @Select("SELECT * FROM error WHERE category_id = #{categoryId}")
    List<Error> selectErrorByCategoryId(Long categoryId);
    // 根据id查询error
    @Select("SELECT * FROM error WHERE id = #{id}")
    List<Error> selectErrorById(Long id);
    @Select("SELECT * FROM error")
    List<Error> selectAllError();
}
