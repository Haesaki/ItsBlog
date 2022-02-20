package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorizationMapper {
    String getPramsByUsername(String name);
}