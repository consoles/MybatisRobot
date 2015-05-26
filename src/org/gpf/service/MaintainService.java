package org.gpf.service;

import java.util.ArrayList;
import java.util.List;

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
}
