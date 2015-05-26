package org.gpf.service;

import java.util.ArrayList;
import java.util.List;

import org.gpf.dao.MessageDAO;

/**
 * 维护相关的业务功能(添加、删除消息)
 * @author gaopengfei
 * @date 2015-5-26 下午6:14:31
 */
public class MaintainService {

	/**
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(String id){
		
		if (id != null && !"".equals(id.trim())) {
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.deleteOne(Integer.parseInt(id));
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch(String[] ids){
		
		MessageDAO messageDAO = new MessageDAO();
		List<Integer> idList = new ArrayList<Integer>();
		for (String s : ids) {
			idList.add(Integer.parseInt(s));
		}
		
		messageDAO.deleteBatch(idList);
	}
	
	/**
	 * 插入一条消息
	 * @param command
	 * @param description
	 * @param content
	 */
	public void insertMessage(String command,String description,String content){
		
		if (command != null && !"".equals(description.trim()) && content != null && !"".equals(content.trim())) {
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.insertMessage(command, description, content);
		}
	}
}
