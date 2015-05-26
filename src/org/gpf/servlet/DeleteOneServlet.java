package org.gpf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gpf.service.MaintainService;
/**
 * 单条删除控制层
 * @author gaopengfei
 * @date 2015-5-26 下午6:19:00
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 接收页面参数
		String id = request.getParameter("id");
		// 向页面传值
		MaintainService maintainService = new MaintainService();
		maintainService.deleteOne(id);
		// 跳转
		request.getRequestDispatcher("/List.action").forward(request, response); 
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
