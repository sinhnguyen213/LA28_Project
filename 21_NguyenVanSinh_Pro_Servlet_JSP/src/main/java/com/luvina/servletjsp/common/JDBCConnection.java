/**
 * Copyright(C) 2021 Luvina
 * JDBCConnection.java, Nov 12, 2021 Sinhnv
 */
package com.luvina.servletjsp.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class JDBCConnection: thực hiện kết nối Java với database
 * 
 * @author Sinhnv
 *
 */
public class JDBCConnection {
//	private String url="jdbc:mysql://localhost/users";
//	private String user="root";
//	private String password="nhungMotkhi213?";

	private String url;
	private String user;
	private String password;

	// code block khởi tạo giá trị cho thuộc tính
	{
		url = getProperties("URL");
		user = getProperties("USER");
		password = getProperties("PASSWORD");
	}

	protected Connection connection;

	/**
	 * Phương thức lấy thông tin truy cập database từ file properties
	 * 
	 * @param prop proerties muốn lấy
	 * @return trả về thông tin properties tương ứng, trả về null nếu không tìm thấy
	 *         properties
	 */
	public String getProperties(String prop) {

		// Khai báo đối tượng inputStream để đọc thông tin file
		InputStream input = null;
		try {
			// Tạo đối tượng properties để đọc thông tin properties
			Properties properties = new Properties();

			// Khởi tại đối tượng inputStream với đường dẫn dẫn đến file properties
			input = this.getClass().getClassLoader().getResourceAsStream("databaseUrl.properties");
//			input = new FileInputStream("files\\databaseUrl.properties");
			// load luồng inputStream
			properties.load(input);
			// trả về kết quả của properties
			return properties.getProperty(prop);
		} catch (IOException e) {
			System.out.println("JDBCConnection_getProperties(): " + e.getMessage());
			// trả về null nếu xảy ra lỗi
			return null;
		} finally {
			// Đóng inputStream
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Phương thức getJDBCConnection thực hiện và trả về kết quả kết nối
	 * 
	 * @return
	 */
	public void openConnection() throws ClassNotFoundException, SQLException {
		try {
			// Kết nối Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Thực hiện kết nối jdbc và trả về kết quả
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
//			throw new ClassNotFoundException("JDBCConnection_openConnection(): " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			throw new SQLException("JDBCConnection_openConnection(): " + e.getMessage());
		}
	}

	/**
	 * Phương thức close connection database
	 * 
	 * @param connection đối tượng stream cần đóng
	 */
	public void closeConnnection() throws SQLException {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new SQLException("JDBCConnection_closeConnection(): " + e.getMessage());
		}
	}

	public void print() {
		byte[] dt;
		try {

			InputStream input = this.getClass().getClassLoader().getResourceAsStream("databaseUrl.properties");
			if (input != null) {
				dt = input.readAllBytes();
				String string = new String(dt);
				System.out.println(string);
			} else {
				System.out.println("input is null");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JDBCConnection connection = new JDBCConnection();

//		connection.print();
		try {
			connection.openConnection();

			System.out.println(connection.connection);
			System.out.println("ket noi thanh cong");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
