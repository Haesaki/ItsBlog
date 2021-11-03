package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sincq.itsblog.entity.Tag;

import java.util.List;

@Mapper
public interface TagMapper {
    int insertTag(Tag Tag);

    void deleteTagById(Integer id);

    void deleteTagByName(String name);

    int updateTagById(Integer id, String name);

    Tag getTagById(Integer id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();
}
