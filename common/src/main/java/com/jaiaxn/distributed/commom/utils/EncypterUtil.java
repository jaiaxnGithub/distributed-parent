package com.jaiaxn.distributed.commom.utils;

import org.jasypt.util.text.BasicTextEncryptor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: wang.jiaxin
 * @date: 2019年07月08日
 * @description:
 **/
public class EncypterUtil {
    private static String enKey="www.jaiaxn.com";

    public static String getEncrypt(String pwd){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(enKey);
        return textEncryptor.encrypt(pwd);
    }

    public static String getDecrypt(String enPwd){
        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
        textEncryptor2.setPassword(enKey);
        return textEncryptor2.decrypt(enPwd);
    }

    public static Properties loadPropertiesFromFile(String filename) throws IOException {
        Properties p = new Properties();
        InputStream input = EncypterUtil.class.getClassLoader().getResourceAsStream(filename);
        p.load(input);
        return p;
    }

    public static String getKey() throws IOException{
        Properties p = loadPropertiesFromFile("key.properties");
        return p.getProperty("encrypt");
    }

    public static void main(String args[]) throws IOException{
        //加密
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("www.jaiaxn.com");
        String newPassword = textEncryptor.encrypt("jaiaxn");
        System.out.println(newPassword);
        //解密
        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
        textEncryptor2.setPassword("www.jaiaxn.com");
        String oldPassword = textEncryptor2.decrypt(newPassword);
        System.out.println(oldPassword);
    }
}
