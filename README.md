# MybatisRobot
使用Mybatis开发智能回复机器人
## 项目经验 ##
- 将所有的jsp页面放在WEB-INF/jsp下，这样前台的请求就不能够直接访问jsp页面了（必须通过控制器），便于控制。
- 将所有的图片、css样式、js等单独建立目录存放，存放在WebRoot的resource目录下。
- 放在WEB-INF/jsp目录下的jsp文件最好也按照前台页面和后台页面进行分类

## 问题及解决方案 ##
- 使用JNDI配置Tomcat数据源，在获得数据库连接的类中就不能用main方法进行测试了，会抛出异常：

		javax.naming.NoInitialContextException: Need to specify class name in environment or system property, or as an applet parameter, or in an application resource file:  java.naming.factory.initial
  出现以上原因是因为java单元的环境是jdk；而jsp的环境却是tomcat；数据连接池是在tomcat中配置的，所以能正常运行的，但java测试的环境只有jdk，所以在引用数据连接池时就时出现找不环境的错误。
- 在使用MySQL进行模糊查询的时候一定要注意在预处理	语句中最好只写？不要把%写入到里面，最后在查询之前通过`pstmt.setString(1, "%" + keyword + "%");`的方式给占位符填入内容。即：应该采用下面的方式：

		String sql = "SELECT id,command,description,content FROM message WHERE command = ? OR description LIKE ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "查看");
		pstmt.setString(2, "%" + "精彩内容" + "%");
	
		rs = pstmt.executeQuery();

下面的这种方式容易导致**Parameter   index   out   of   range   (1   >   number   of   parameters,   which   is   0).**这样的问题。

	String sql = "SELECT id,command,description,content FROM message WHERE command = ? OR description LIKE %?%";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, "查看");
	pstmt.setString(2, "精彩内容");

- Mybatis异常：

![](http://i.imgur.com/SJbXobf.jpg)
解决方案：MyBatis3.3.0可能存在以上的问题，下载3.2.8完美解决