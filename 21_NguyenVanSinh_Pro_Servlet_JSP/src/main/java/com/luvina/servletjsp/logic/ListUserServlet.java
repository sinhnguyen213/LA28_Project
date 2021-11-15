/**
 * Copyright(C) 2021 Luvina
 * ListUserServlet.java, Nov 12, 2021 Sinhnv
 */
package com.luvina.servletjsp.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luvina.servletjsp.model.UserBean;
import com.luvina.servletjsp.model.UserModel;

/**
 * Servlet ListUserServlet thực hiện tương tác cho tầng view
 * xử lí chức năng hiện thị danh sách user từ database
 * @author Sinhnv
 *
 */
public class ListUserServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Khởi tạo đối tượng UserModel để thực hiện thao tác lấy dữ liệu
		UserModel userModel = new UserModel();

		try {
			//Tạo đối tượng List để lưu list user từ UserModel
			List<UserBean> listUser = userModel.getUsers();
			// Tạo đối tượng session để lưu và gửi data
			HttpSession session = request.getSession();
			// setup data listUser vừa lấy được cho thuộc tính listUser
			session.setAttribute("listUser", listUser);
			// Chuyển hướng đến trang users.jsp
			response.sendRedirect("listUser.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
