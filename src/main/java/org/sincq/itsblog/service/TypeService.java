package org.sincq.itsblog.service;

import org.sincq.itsblog.entity.Type;

import java.util.List;

public interface TypeService {
    boolean insertType(Type type);

    boolean deleteTypeById(Integer id);

    boolean deleteTypeByName(String name);

    Type getTypeById(Integer id);

    Type getTypeByName(String name);

    List<Type> getAllType();
}
