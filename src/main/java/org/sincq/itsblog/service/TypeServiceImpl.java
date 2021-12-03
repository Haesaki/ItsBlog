package org.sincq.itsblog.service;

import org.sincq.itsblog.dao.TypeMapper;
import org.sincq.itsblog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TypeServiceImpl implements TypeService{
    @Autowired
    TypeMapper typeMapper;

    @Override
    public boolean insertType(Type type) {
        Type dbType1 = typeMapper.getTypeByName(type.getName());
        Type dbType2 = typeMapper.getTypeById(type.getId());
        if(dbType1 != null || dbType2 != null)
            return false;
        typeMapper.insertType(type);
        return true;
    }

    @Override
    public boolean deleteTypeById(Integer id) {
        Type dbType = typeMapper.getTypeById(id);
        if(dbType == null)
        return false;
        typeMapper.deleteTypeById(id);
        return true;
    }

    @Override
    public boolean deleteTypeByName(String name) {
        Type dbType = typeMapper.getTypeByName(name);
        if(dbType != null)
            return false;
        typeMapper.deleteTypeByName(name);
        return true;
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }
}
