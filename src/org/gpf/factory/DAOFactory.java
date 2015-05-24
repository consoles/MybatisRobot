package org.gpf.factory;

import org.gpf.dao.IMessageDAO;
import org.gpf.dao.impl.proxy.MessageDAOProxy;

/**
 * 静态工厂，返回DAO的代理
 * @author gaopengfei
 * @date 2015-5-24 下午8:52:58
 */
public class DAOFactory {

	public static IMessageDAO getIMessageDAOInstance(){
		
		return new MessageDAOProxy();
	}
}
