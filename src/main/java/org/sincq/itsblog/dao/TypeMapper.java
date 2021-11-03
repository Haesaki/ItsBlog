package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sincq.itsblog.entity.Type;

import java.util.List;

@Mapper
public interface TypeMapper {
    int insertType(Type type);

    void deleteTypeById(Integer id);

    void deleteTypeByName(String name);

    int updateTypeById(Integer id, String name);

    Type getTypeById(Integer id);

    Type getTypeByName(String name);

    List<Type> getAllType();
}
