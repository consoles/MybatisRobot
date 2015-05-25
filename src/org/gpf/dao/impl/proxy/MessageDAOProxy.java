package org.gpf.dao.impl.proxy;

import java.util.List;

import org.gpf.bean.Message;
import org.gpf.dao.IMessageDAO;
import org.gpf.dao.impl.MessageDAOImpl;
import org.gpf.util.DBConnection;
/**
 * 代理操作类，完成比真实主题更多的角色，例如数据库的连接和释放
 * @author gaopengfei
 * @date 2015-5-24 下午8:38:21
 */
public class MessageDAOProxy implements IMessageDAO {

	private DBConnection dbc = null;
	private IMessageDAO dao = null;
	
	public MessageDAOProxy() {
		this.dbc = new DBConnection();
		this.dao = new MessageDAOImpl(this.dbc.getConnection());// 持有对真实主题角色的引用
	}
	
	@Override
	public List<Message> findAll() throws Exception {
		
		List<Message> messages = null;
		messages = this.dao.findAll();
		this.dbc.closeConnection();
		return messages;
	}

	@Override
	public List<Message> findAll(String key1, String key2) throws Exception {
		
		List<Message> messages = null;
		messages = this.dao.findAll(key1, key2);
		this.dbc.closeConnection();
		return messages;
	}

}
