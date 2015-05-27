package org.gpf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gpf.service.QueryService;

/**
 * 列表页面初始化控制层
 * @author gaopengfei
 * @date 2015-5-24 下午4:03:22
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 接收页面参数
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		
		// 向页面传值
		request.setAttribute("command", command);		// 把接收到的值放在request中，在前台可以通过EL表达式取出	
		request.setAttribute("description", description);
		QueryService listService = new QueryService();
		request.setAttribute("messageList", listService.queryMessagesList(command, description));
		
		// 跳转
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response); 
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
