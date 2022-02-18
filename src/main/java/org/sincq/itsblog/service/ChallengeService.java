package org.sincq.itsblog.service;

public interface ChallengeService {
    public String getChallengeByUsername(String userName);

    public String getChallengeByUsernameAFlushChallenge(String userName);

    public String getMD5ByUsername(String username);

    public void updateMD5ByUsername(String username, String md5);
}
