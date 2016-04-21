package com.asm.util;

import java.lang.reflect.ParameterizedType;

/**  
* @description: 获取超类工具类
* @Author: 张毓峰（作者）
* @Version: V1.00 （版本号）
* @Create Date: 2016-4-8 （创建日期）
*/
public class GenericSuperClass {



	public static Class getClass(Class tClass) {
		//getGenericSuperclass��ô��з��͵ĸ���
		ParameterizedType pt = (ParameterizedType) tClass.getGenericSuperclass();
		//getActualTypeArguments��ȡ�������͵����飬���Ϳ����ж��
		Class entity = (Class)pt.getActualTypeArguments()[0];
		return entity;
	}
}
