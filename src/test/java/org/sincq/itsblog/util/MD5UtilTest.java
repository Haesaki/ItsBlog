package org.sincq.itsblog.util;

import org.junit.jupiter.api.Test;

public class MD5UtilTest {
    @Test
    public void md5Test(){
        String str = "admin";
        System.out.println(MD5Util.encrypt(str));
    }
}
