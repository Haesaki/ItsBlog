package org.sincq.itsblog.service.Impl;

import org.sincq.itsblog.dao.UserChallengeMapper;
import org.sincq.itsblog.dao.UserMapper;
import org.sincq.itsblog.entity.User;
import org.sincq.itsblog.service.ChallengeService;
import org.sincq.itsblog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private UserChallengeMapper challengeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getChallengeByUsername(String userName) {
        return challengeMapper.getChallengeByUsername(userName);
    }

    @Override
    public String getChallengeByUsernameAFlushChallenge(String userName) {
        // TODO: 问题在这里
        String challenge = challengeMapper.getChallengeByUsername(userName);
        User user = userMapper.getUserByUsername(userName);
        String md5 = MD5Util.encrypt(user.getPassword() + challenge);

        challengeMapper.updateMD5ByUsername(userName, md5);

        String challengeFlush = UUID.randomUUID().toString();
        challengeMapper.updateChallengeByUsername(userName, challengeFlush);
        return challenge;
    }

    @Override
    public String getMD5ByUsername(String username) {
        return challengeMapper.getMD5ByUsername(username);
    }

    @Override
    public void updateMD5ByUsername(String username, String md5) {
        challengeMapper.updateMD5ByUsername(username, md5);
    }
}
