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
			Message message = new Message();								// 实例化传入SQL语句的对象
			message.setCommand(command);									// 为对象设置属性字段
			message.setDescription(description);
			// 通过SqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessagesList",message);// 名称空间.SQL语句ID
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null)
				sqlSession.close();
		}
		return messageList;
	}
	
	/**
	 *  删除单条记录
	 * @param id
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;				
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();						// 删除的时候需要手动提交事务
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;				
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();						// 删除的时候需要手动提交事务
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (sqlSession != null)
				sqlSession.close();
		}
	}
}
