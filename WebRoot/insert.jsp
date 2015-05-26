<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加消息</title>
  </head>
  
  <body>
    <form action="<%=basePath %>Insert.action" method="post">
    	<center>
    	<table border="1">
    		<tr>
    			<th>指令名称</th>
    			<th>描述</th>
    			<th>操作</th>
    		</tr>
    		<tr>
    			<td><input type="text" name="command"/></td>
    			<td><input type="text" name="description"/></td>
    			<td><input type="text" name="content"/></td>
    		</tr>
    	</table>
    	<input type="submit" value="提交">
    	</center>
    </form>
  </body>
</html>
