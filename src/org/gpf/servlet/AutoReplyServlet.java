package org.gpf.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gpf.service.QueryService;
/**
 * 自动回复功能控制层
 * @author gaopengfei
 * @date 2015-5-27 上午8:56:15
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		String content = req.getParameter("content");
		out.write(queryService.queryByCommand(content));
		out.flush();
		out.close();
	}
}
