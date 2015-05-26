/**
 * 调用后台批量删除方法
 */
function deleteBatch(bathPath) {
	$("#mainForm").attr("action",bathPath + "DeleteBatch.action");
	$("#mainForm").submit();
}