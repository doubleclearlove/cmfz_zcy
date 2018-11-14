package com.baizhi.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public static String  getMd5Password(String password){
        byte[] code=null;
        try {
            code=MessageDigest.getInstance("md5").digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String md5code=new BigInteger(1,code).toString(16);
        for (int i=0;i<32 - md5code.length();i++){
            md5code="0"+md5code;
        }
        return md5code;
    }
}
