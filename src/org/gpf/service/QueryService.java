package org.gpf.service;

import java.util.List;

import org.gpf.bean.Message;
import org.gpf.dao.MessageDAO;
import org.gpf.util.Iconst;

/**
 * 查询相关的业务功能
 * Servlet与DAO层通过此层进行交互
 * @author gaopengfei
 * @date 2015-5-26 上午11:12:36
 */
public class QueryService {

	public List<Message> queryMessagesList(String command,String description){
		
		MessageDAO messageDAO = new MessageDAO();
		return messageDAO.queryMessagesList(command, description);
	}
	
	/**
	 * 通过指令查询具体回复的内容
	 * @param command
	 * @return
	 */
	public String queryByCommand(String command) {
		
		MessageDAO messageDAO = new MessageDAO();
		List<Message> messageList = null;
		
		if(Iconst.HELP_COMMAND.equals(command)){
			messageList = messageDAO.queryMessagesList(null, null); // 全检索
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < messageList.size(); i++) {
				if(i!=0)
					sb.append("<br />");							// 除了第一条指令，其他的都要在前面换行
				sb.append("回复["+ messageList.get(i).getCommand() +"]查看" + messageList.get(i).getDescription());
			}
			return sb.toString();
		}
		
		messageList = messageDAO.queryMessagesList(command, null);
		if(messageList.size() > 0)
			return messageList.get(0).getContent();
		
		return Iconst.NO_MATCH_CONTENT;
	}
	
}
