# MybatisRobot
使用Mybatis开发智能回复机器人
## 项目经验 ##
- 将所有的jsp页面放在WEB-INF/jsp下，这样前台的请求就不能够直接访问jsp页面了（必须通过控制器），便于控制。
- 将所有的图片、css样式、js等单独建立目录存放，存放在WebRoot的resource目录下。
- 放在WEB-INF/jsp目录下的jsp文件最好也按照前台页面和后台页面进行分类