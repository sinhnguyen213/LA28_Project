/**
 * Copyright(C) 2021 Luvina
 * User.java, Nov 12, 2021 Sinhnv
 */
package com.luvina.servletjsp.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Sinhnv
 *
 */
public class UserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private Date birthday;
	private String birthPlace;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String toString() {
		return id + "_" + name + "_" + birthday.toString() + "_" + birthPlace;
	}

}
