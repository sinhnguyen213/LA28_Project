/**
 * Copyright(C) 2021 Luvina
 * Common.java, Nov 12, 2021 Sinhnv
 */
package com.luvina.servletjsp.common;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Class common chứa các phương thức dùng chung cho class khác
 * @author Sinhnv
 *
 */
public class Common {

	public static Date parseStringToDate(String str) {
		Date date = null;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = (Date) ft.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	

	
	public static void main(String[] args) {
		Date date = parseStringToDate("1996-03-21");
		System.out.println(date);
	}
}
