package org.gpf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.setCharacterEncoding("utf-8");
		
		// 接收页面参数
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		
		// 把接收到的值放在request中，在前台可以通过EL表达式取出
		request.setAttribute("command", command);			
		request.setAttribute("description", description);
		try {
//			List<Message>messages = DAOFactory.getIMessageDAOInstance().queryMessageList(command, description); // 查询消息列表
//			request.setAttribute("messages", messages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response); // 跳转
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
