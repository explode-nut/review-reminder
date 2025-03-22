package com.czn.reviewreminder.mvc.mapper;

import com.czn.reviewreminder.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    /*
    public record Tag(Long id, String name, Long categoryId, Long errorId) {
    }
     */
    @Insert("INSERT INTO tag (name, category_id, error_id) VALUES (#{name}, #{categoryId}, #{errorId})")
    void insertTag(Tag tag);
    @Delete("DELETE FROM tag WHERE id = #{id}")
    void deleteTag(Long id);
    @Select("SELECT * FROM tag")
    List<Tag> selectTag();
    // 通过categoryId查询
    @Select("SELECT * FROM tag WHERE category_id = #{categoryId}")
    List<Tag> selectTagByCategoryId(Long categoryId);
    // 通过errorId查询
    @Select("SELECT * FROM tag WHERE error_id = #{errorId}")
    List<Tag> selectTagByErrorId(Long errorId);
    @Select("SELECT * FROM tag WHERE id = #{id}")
    List<Tag> selectTagById(Long id);
    // 修改
    @Update("UPDATE tag SET name = #{name}, category_id = #{categoryId}, error_id = #{errorId} WHERE id = #{id}")
    void updateTag(Tag tag);
}
