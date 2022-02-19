package org.sincq.itsblog.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MD5UtilTest {
    @Test
    public void md5Test() {
        String str = "cbe18cc4-245c-46da-932f-49f3497de8f7admin";
        str = MD5Util.encrypt(str);
//        str.replaceAll("-", "");
//        System.out.println(str);
//        System.out.println(MD5Util.encrypt(str));
        Assertions.assertTrue("9212628ea5d572a5d77b1ccc03dc0a57".equals(str));
    }
}
