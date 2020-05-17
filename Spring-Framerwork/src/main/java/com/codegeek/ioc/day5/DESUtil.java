package com.codegeek.ioc.day5;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class DESUtil {
    private static Key key;
    private static String KEY_STR = "myKey";
    private static String CHAR_SET_NAME = "UTF-8";
    private static String ALGORITHM = "DES";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEY_STR.getBytes());
            generator.init(secureRandom);
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEncryptString(String str) {
        Base64.Encoder encoder = Base64.getEncoder();
        try {
            byte[] bytes = str.getBytes(CHAR_SET_NAME);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return encoder.encodeToString(doFinal);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String getDecryptString(String str) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] bytes = decoder.decode(str);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal, CHAR_SET_NAME);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public static void main(String[] args) {
        System.out.println(getEncryptString("123456"));
        System.out.println(getEncryptString("root"));
    }
}