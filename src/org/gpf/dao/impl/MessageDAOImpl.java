package org.gpf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.gpf.bean.Message;
import org.gpf.dao.IMessageDAO;

/**
 * 真实主题角色，完成具体的业务逻辑操作
 * @author gaopengfei
 * @date 2015-5-24 下午8:34:10
 */
public class MessageDAOImpl implements IMessageDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;
	
	Message m = null;
	List<Message> messages;
	
	public MessageDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Message> findAll() throws Exception {
		
		String sql = "SELECT id,command,description,content FROM message";
		messages = new ArrayList<Message>();
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			m = new Message();
			messages.add(m);	// 由于操作的是引用数据类型，先加入和后加入并没有任何区别
			m.setId(rs.getString("id"));
			m.setCommand(rs.getString("command"));
			m.setDescription(rs.getString("description"));
			m.setContent(rs.getString("content"));
		}
		return messages;
	}

	@Override
	public List<Message> findAll(String key1, String key2) throws Exception {
		
		String sql = "SELECT id,command,description,content FROM message WHERE command = ? OR description LIKE ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "查看");
		pstmt.setString(2, "%" + "精彩内容" + "%");
		messages = new ArrayList<Message>();
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			m = new Message();
			messages.add(m);	// 由于操作的是引用数据类型，先加入和后加入并没有任何区别
			m.setId(rs.getString("id"));
			m.setCommand(rs.getString("command"));
			m.setDescription(rs.getString("description"));
			m.setContent(rs.getString("content"));
		}
		return messages;
	}

}
