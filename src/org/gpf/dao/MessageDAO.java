package org.gpf.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gpf.bean.Message;
import org.gpf.db.DBAccess;

/**
 * 和message表相关的操作
 * @author gaopengfei
 * @date 2015-5-25 上午10:52:19
 */
public class MessageDAO {

	/**
	 * 根据条件查询消息列表
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessagesList(String command,String description){
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;				
		List<Message> messageList = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();							// 在DAO层进行异常处理
			// 通过SqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessagesList");// 名称空间.SQL语句ID
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null)
				sqlSession.close();
		}
		return messageList;
	}
	
	/**
	 * 测试是否取得SqlSession
	 * @param args
	 */
	public static void main(String[] args) {
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.queryMessagesList("", "");
	}
}
