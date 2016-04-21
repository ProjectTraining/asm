package com.asm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import org.apache.struts2.ServletActionContext;
/**  
* @description:文件上传工具类
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
public class FileUpLoadUtil {
	/*public static String singleUp(File pic,String picFileName,String realPath)
	{
		File sa=new File(realPath,picFileName);
		InputStream in=null; 
		OutputStream ou=null;
		try { 
			sa.getParentFile().mkdirs();
			in=new FileInputStream(pic);
			ou=new FileOutputStream(sa);
			byte[] b=new byte[1024];
			int len=0;
		    while((len=in.read(b))!=-1)
			 {
			  ou.write(b,0,len); 
			 }
			in.close();
			ou.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}*/
	public static String fileUp(File[] pic,String[] picFileName,String[] picContentType,String dir)
	{
	
		for(int i=0;i<pic.length;i++)
		{
			//System.out.println((ServletActionContext.getServletContext().getRealPath(dir)));
			File sa=new File(ServletActionContext.getServletContext().getRealPath(dir),picFileName[i]);
			InputStream in=null; 
			OutputStream ou=null;
			try {   
				sa.getParentFile().mkdirs();
				in=new FileInputStream(pic[i]);
				ou=new FileOutputStream(sa);
				byte[] b=new byte[1024];
				int len=0;
			    while((len=in.read(b))!=-1)
				 {
				  ou.write(b,0,len); 
				 } 
				in.close();
				ou.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return "success";
	}
}
