package org.sincq.itsblog.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserChallengeMapper {
    public String getChallengeByUsername(String username);

    public void updateChallengeByUsername(String username, String challenge);

    public String getMD5ByUsername(String username);

    public void updateMD5ByUsername(String username, String md5);

}
