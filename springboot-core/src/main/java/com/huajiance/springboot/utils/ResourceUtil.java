package com.huajiance.springboot.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;

/**
 * 项目参数工具类
 * 
 * @author userstrator
 * 
 */
public class ResourceUtil {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}
	
	/**
	 * 获得sessionUser名字
	 * 
	 * @return
	 */
	public static final String getSessionUserName() {
		return bundle.getString("sessionUserName");
	}

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static final String getUkeySessionInfoName() {
		return bundle.getString("sessioUkeyInfoName");
	}

	/**
	 * 获取配置文件对应的键值
	 * 
	 * @return
	 */
	public static final String getMessageByConfig(String param) {
		return bundle.getString(param);
	}
	
	/**
	 * 获取配置文件对应的键值，返回int
	 * @param param
	 * @return
	 */
	public static final Integer getIntMessageByConfig (String param){
		return Integer.valueOf(bundle.getString(param));
	}
	
	/**
	 * 获取配置文件对应的键值
	 * @param param
	 * @param defaultValue
	 * @return
	 */
	public static final String getMessageByConfig (String param, String defaultValue){
		String value = bundle.getString(param);
		if (StringUtils.isNotEmpty(value)){
			return value;
		}
		return defaultValue;
	}
	
	/**
	 * 获取配置文件对应的键值，返回int
	 * @param param
	 * @return
	 */
	public static final Integer getIntMessageByConfig (String param, Integer defaultValue) {
		String value = bundle.getString(param);
		if (StringUtils.isNotEmpty(value)){
			return Integer.valueOf(value);
		}
		return defaultValue;
	}
	/**
	 * 
	 * @return
	 */
	public static String getImagePath(String str) {
        return getMessageByConfig(str);
    }
	
	public static String getImagePath() {
        return getImagePath("imagePath");
    }

	/**
	 * 获得文件服务器相对路径
	 * @return
	public static String fileServicePath (){
		return getMessageByConfig("file_service_path");
	}
	*/
	/**
	 * 获得文件服务器本地路径
	 * @return
	 */
	public static String filePath (){
		return getMessageByConfig("file_path");
		
	}
	
	/**
	 * 获得上传表单域的名称
	 * 
	 * @return
	 */
	public static final String getUploadFieldName() {
		return bundle.getString("uploadFieldName");
	}

	/**
	 * 获得上传文件的最大大小限制
	 * 
	 * @return
	 */
	public static final long getUploadFileMaxSize() {
		return Long.valueOf(bundle.getString("uploadFileMaxSize"));
	}

	/**
	 * 获得允许上传文件的扩展名
	 * 
	 * @return
	 */
	public static final String getUploadFileExts() {
		return bundle.getString("uploadFileExts");
	}

	/**
	 * 获得上传文件要放到那个目录
	 * 
	 * @return
	 */
	public static final String getUploadDirectory() {
		return bundle.getString("uploadDirectory");
	}

	/**
	 * 转换字符串编码,默认UTF-8
	 * 
	 * @param str
	 * @return
	 */
	public static String getCharSetEncodeStr(String str) {
		return getCharSetEncodeStr(str, "UTF-8");
	}

	/**
	 * 转换字符串编码
	 * 
	 * @param str
	 * @param code
	 * @return
	 */
	public static String getCharSetEncodeStr(String str, String code) {
		try {
			return new String(str.getBytes("ISO-8859-1"), code);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 获得配置文件信息根据key值
	 * 
	 * @param key
	 * @return
	 */
	public static final String getConfigValueByKey(String key) {
		return bundle.getString(key);
	}
	
	/**
	 * 获取配置文件对应的键值
	 * 
	 * @return
	 */
	public static String getValueByKey(String key) {
		return bundle.getString(key);
	}
	
	public static int getIntValueByKey(String key) {
		return new Integer(getValueByKey(key));  
	}
	
	/**
	 * 将对象转换成JSON字符串
	 * 
	 * @param object
	 * @throws IOException
	 */
	public static String getJson(Object object) {
		String json = "";
		try {
			// SerializeConfig serializeConfig = new SerializeConfig();
			// serializeConfig.setAsmEnable(false);
			// String json = JSON.toJSONString(object);
			// String json = JSON.toJSONString(object, serializeConfig,
			// SerializerFeature.PrettyFormat);
			if (object instanceof String) {
				json = object.toString();
			} else {
				json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static void print(Object object, HttpServletResponse response) {
		print(object, "utf-8", response);
	}
	
	public static void print(Object object, String charSet, HttpServletResponse response) {
		try {
			String json = ResourceUtil.getJson(object);
			response.setContentType("text/html;charset=" + charSet);
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		if (con == null) {
			String jdbcUrl = ResourceUtil.getValueByKey("jdbc_url");
			String driverClassName = ResourceUtil.getValueByKey("driverClassName");
			String jdbcUsername = ResourceUtil.getValueByKey("jdbc_username");
			String jdbcPassword = ResourceUtil.getValueByKey("jdbc_password");
			try {
				Class.forName(driverClassName);
				con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		return con;
	}
	
	/**
	 * 获取returnUrl
	 * 
	 * @return
	 */
	public static String getReturnUrl(HttpServletRequest request) {
		return getReturnUrl(request, true);
	}

	public static String getReturnUrl(HttpServletRequest request, boolean isEncode) {
		StringBuffer returnUrl = request.getRequestURL();
		if (StringUtils.isNotBlank(request.getQueryString())) {
			returnUrl.append("?");
			returnUrl.append(request.getQueryString());
		}
		try {
			return isEncode ? URLEncoder.encode(returnUrl.toString(), "UTF-8") : returnUrl.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnUrl.toString();
	}
}
