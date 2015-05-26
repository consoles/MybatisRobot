package org.gpf.service;

import org.gpf.dao.MessageDAO;

/**
 * 维护相关的业务功能
 * @author gaopengfei
 * @date 2015-5-26 下午6:14:31
 */
public class MaintainService {

	/**
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(String id){
		
		if(id!=null&&!"".equals(id.trim())){
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.deleteOne(Integer.parseInt(id));
		}
	}
}
