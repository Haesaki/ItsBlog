package org.sincq.itsblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
//    public static void main(String[] args) {
//        System.out.println(MD5Util.encrypt("admin"));
//    }
    private static final String SALT = "E^T#T1`%)$,6~EX3WB=ZZJE$)B!H^#MD";
    private static final String SUFFIX = "_M+>T1";

    public static String encrypt(String str){
        // 如果长度小于32. 就用str替代SALT的前str.length()位
        // 如果长度大于32, 就在str后面补上SUFFIX
        if(str.length() < 32){
            str = str + SALT.substring(str.length());
        }else{
            str = str + SUFFIX;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
