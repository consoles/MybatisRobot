package org.gpf.service;

import java.util.List;

import org.gpf.bean.Message;
import org.gpf.dao.MessageDAO;

/**
 * 列表相关的业务功能
 * Servlet与DAO层通过此层进行交互
 * @author gaopengfei
 * @date 2015-5-26 上午11:12:36
 */
public class ListService {

	public List<Message> queryMessagesList(String command,String description){
		
		MessageDAO messageDAO = new MessageDAO();
		return messageDAO.queryMessagesList(command, description);
	}
}
