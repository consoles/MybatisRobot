package org.gpf.dao;

import java.util.List;

import org.gpf.bean.Message;

/**
 * 数据访问接口
 * @author gaopengfei
 * @date 2015-5-24 下午8:31:12
 */
public interface IMessageDAO {
	
	public List<Message>findAll() throws Exception;	// 查询所有的消息
}
