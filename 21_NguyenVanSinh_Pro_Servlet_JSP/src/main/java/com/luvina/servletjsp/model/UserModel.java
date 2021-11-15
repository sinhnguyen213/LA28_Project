/**
 * Copyright(C) 2021 Luvina
 * UserModel.java, Nov 12, 2021 Sinhnv
 */
package com.luvina.servletjsp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luvina.servletjsp.*;
import com.luvina.servletjsp.common.JDBCConnection;


/**
 * @author Sinhnv
 *
 */
public class UserModel extends JDBCConnection{
	
	/**
	 * Phương thức getUsers() có chức năng lấy và trả về danh sách user từ database
	 * @return trả về danh sách user từ database, nếu không có user trong database trả về danh sách rỗng
	 * @throws SQLException ném exception cho đối tượng gọi phương thức này
	 */
	public List<UserBean> getUsers() throws SQLException {
		// Tạo danh sách lưu đối tượng User à kết quả của tìm kiếm
		List<UserBean> listUsers = new ArrayList<>();
		try {
			
			// Tạo kết nối với db
			openConnection();
			if (connection != null) {

				// Tạo câu lệnh sql bằng StrinhBuilder và thêm nội dung câu lệnh truy vấn
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT * FROM user; ");

				// Tạo đối tượng PreparedStatement để thực hiện câu lệnh truy vấn
				PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand.toString());
				// Thực hiện truy vấn vào gán kết quả trả về cho đối tượng ResultSet
				ResultSet result = preparedStatement.executeQuery();
				// duyệt đối tượng được tìm kiếm
				while (result.next()) {
					// Tạo đối tượng JavaBean và add và danh sách kết quả
					UserBean UserBean = new UserBean();
					// Set các giá trị cho các thuộc tính của đối tượng User
					UserBean.setId(result.getInt("id"));
					UserBean.setName(result.getString("name"));
					UserBean.setBirthday(result.getDate("birthday"));
					UserBean.setBirthPlace(result.getString("birthplace"));
					// add vào danh sách
					listUsers.add(UserBean);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("UserModel_getUsers(): " + e.getMessage());
		} finally {
			// Đóng kết nối
			closeConnnection();
		}

		return listUsers;
	}
	

}
