package com.gxa.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {

    /**
     * 编码
     *
     * @param str
     */

    public static String encode(String str) {

        String encode = null;
        try {
            encode = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return encode;

    }

    /**
     * 解码
     *
     * @param encodeString
     */

    public static String decode(String encodeString) {

        byte[] decode = Base64.getDecoder().decode(encodeString);

        String decodeString = new String(decode);

        return decodeString;

    }
}