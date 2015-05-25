package org.gpf.dao;

import java.util.List;

import org.gpf.bean.Message;

/**
 * 数据访问接口
 * @author gaopengfei
 * @date 2015-5-24 下午8:31:12
 */
public interface IMessageDAO {
	
	/**
	 * 根据关键字查询消息
	 */
	public List<Message>findAll(String key1,String key2) throws Exception;
}
