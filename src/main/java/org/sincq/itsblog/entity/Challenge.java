package org.sincq.itsblog.entity;

import lombok.Data;

@Data
public class Challenge {
    private String username;
    // 对应的是新的challenge
    // 每次尝试登录都会将challenge发送到前端,并且根据密码合并算出 md5,并且更新md5
    private String challenge;

    // 实际上登录需要获取到的数据
    // 如果不是这个数据就出错了
    private String md5;
}
