package org.sincq.itsblog.service.Impl;

import org.sincq.itsblog.dao.AuthorizationMapper;
import org.sincq.itsblog.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private AuthorizationMapper authorizationMapper;

    @Override
    public String getPramsByUsername(String name) {
        return authorizationMapper.getPramsByUsername(name);
    }
}
