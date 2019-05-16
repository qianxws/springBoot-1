package com.huajiance.springboot.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * 密码加密方法
 * @author hanxu
 */
@Component
public class PasswordUtils implements PasswordEncoder{

	/**
	 * 密码加密
	 *//*
	@Override
	public String encode(CharSequence rawPassword) {


		return rawPassword.toString() + "_" + rawPassword.length() + "_" + rawPassword.hashCode();
	}*/

	public static String byte2hex(byte[] b)
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++)
		{
			stmp = Integer.toHexString(b[n] & 0xFF);
			if (stmp.length() == 1)
			{
				hs = hs + "0" + stmp;
			}
			else
			{
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	@Override
	public String encode(CharSequence rawPassword) {
		if(rawPassword==null)return null;
		String password = rawPassword.toString();
		if(password.isEmpty())return password;
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-1"); //$NON-NLS-1$
			byte[] bytes = password.getBytes();
			bytes = md.digest(bytes);
			md.reset();
			bytes = md.digest(bytes);
			return '*' + byte2hex(bytes);

		}catch(Exception e){
			return null;
		}
	}

	/**
	 * 验证加密密码
	 * @param rawPassword : 用户输入密码
	 * @param encodedPassword ： 加密后的正确密码
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		return encodedPassword != null && encodedPassword.equals(encode(rawPassword));
	}

}
