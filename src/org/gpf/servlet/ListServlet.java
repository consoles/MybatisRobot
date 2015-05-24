package org.gpf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gpf.util.DBConnection;

/**
 * 列表页面初始化控制
 * @author gaopengfei
 * @date 2015-5-24 下午4:03:22
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
		if (new DBConnection().getConnection()!=null) {
			System.out.println("数据库连接成功！");
		}else {
			System.out.println("失败！");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
