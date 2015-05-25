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
	public List<Message> findAll(String key1, String key2) throws Exception {
		
		StringBuilder sql = new StringBuilder("SELECT id,command,description,content FROM message WHERE 1 = 1");
		
		List<String> paramList = new ArrayList<String>();	// 该list用来暂存查询参数
		if (key1 != null && !"".equals(key1.trim())) {
			sql.append(" AND command = ?");
			paramList.add(key1);
		}
		if (key2 != null && !"".equals(key2.trim())) {
			sql.append(" AND description LIKE '%' ? '%'");  // 这里需要注意MySQL的字符串拼接
			paramList.add(key2);
		}
		
		pstmt = conn.prepareStatement(sql.toString());		// 调整了这一条语句的位置，修正了MySQL的插入越界错误
		if (paramList!=null) {
			for (int i = 0; i < paramList.size(); i++) {
				pstmt.setString(i+1, paramList.get(i));
			}
		}
		
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
