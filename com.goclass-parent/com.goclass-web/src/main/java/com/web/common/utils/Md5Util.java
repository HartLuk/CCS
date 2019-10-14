package com.web.common.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: Md5Util
 * @Description: MD5加密工具类
 */
public class Md5Util {
	private static final Logger LOG = LoggerFactory.getLogger(Md5Util.class);
	
	/**
	 * 生成随机盐值
	 * 生成一个16位的随机数
	 * @return
	 */
	public static String getSalt() {
		Random random = new Random();
		StringBuilder salt = new StringBuilder(16);
		salt.append(random.nextInt(99999999)).append(random.nextInt(99999999));
		int len = salt.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				salt.append("0");
			}
		}
		
		return salt.toString();
	}

	/**
	 * 通过盐值对字符串进行MD5加密
	 *
	 * @param param	需要加密的字符串
	 * @param salt	盐值
	 * @return
	 */
	public static String MD5(String param, String salt) {
		return MD5(param + salt);
	}

	/**
	 * 加密字符串
	 *
	 * @param s
	 * @return
	 */
	public static String MD5(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes("utf-8");
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (byte byte0 : md) {
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			LOG.error("MD5生成失败", e);
			return null;
		}
	}
	
	/**
	 * 密码验证
	 * @param password	用户输入密码
	 * @param saltPassword	数据库保存的加密密码
	 * @param salt	数据库保存的盐字段
	 * @return
	 */
	public static boolean getSaltverifyMD5(String password, String saltPassword, String salt) {
		return saltPassword.equals(MD5(password, salt));
	}

	public static void main(String[] args) {
		String salt = Md5Util.getSalt();
		System.out.println(salt);

		String password = "123456";
		System.out.println("原密码：" + password);

		String saltPassword = Md5Util.MD5(password, salt);
		System.out.println("md5盐加密：" + saltPassword);

		System.out.println(Md5Util.getSaltverifyMD5(password+1, saltPassword, salt));

	}
}