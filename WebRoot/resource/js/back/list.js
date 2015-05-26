/**
 * 调用后台的删除单条记录的方法
 * @param id 消息的id
 */
function deleteOne(bathPath,id) {
	$("#mainForm").attr("action",bathPath + "DeleteOne.action?id=" + id);
	$("#mainForm").submit();
}

/**
 * 调用后台批量删除方法
 */
function deleteBatch(bathPath) {
	$("#mainForm").attr("action",bathPath + "DeleteBatch.action");
	$("#mainForm").submit();
}