package com.asm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
/**  
* @description:字符串处理工具类
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
public class StringHelper {

	public static Date stringConvertDate(String date) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static Date stringConvertDateTime(String date) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	 public static String datetoString(Date date) {  
		  
	        String time;  
	        SimpleDateFormat formater = new SimpleDateFormat();  
	        formater.applyPattern("yyyy-MM-dd");  
	        time = formater.format(date);  
	        return time;  
	}  
	 public static String dateTimetoString(Date date) {  
		  	if(date==null)
		  		return "";
	        String time;  
	        SimpleDateFormat formater = new SimpleDateFormat();  
	        formater.applyPattern("yyyy-MM-dd HH-mm-ss");  
	        time = formater.format(date);  
	        return time;  
	} 

}
