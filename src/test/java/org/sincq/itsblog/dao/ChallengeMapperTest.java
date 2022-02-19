package org.sincq.itsblog.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChallengeMapperTest {
    @Autowired
    private UserChallengeMapper challengeMapper;

    @Test
    public void selectTest(){
        String name = "admin";
        String challenge = challengeMapper.getChallengeByUsername(name);
        System.out.println(challenge);
    }
}
