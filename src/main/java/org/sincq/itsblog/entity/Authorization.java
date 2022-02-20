package org.sincq.itsblog.entity;

import lombok.Data;

@Data
public class Authorization {
    private String name;
    private String md5;
    private String prams;
}
