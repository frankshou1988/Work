package com.tetrapak.util.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {

    public static String MD5(String from) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	BASE64Encoder base64en = new BASE64Encoder();
	String to = base64en.encode(md5.digest(from.getBytes("utf-8")));
	return to;
    }

}
