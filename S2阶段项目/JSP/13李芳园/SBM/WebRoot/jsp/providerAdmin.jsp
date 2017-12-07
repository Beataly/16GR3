<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='provider?cmd=getAllProvider&&action=add'" /></em>
			<div class="title">供应商管理&gt;&gt;</div>
	</div>
		<div class="content">
			<table class="list">
				<tr>
					<td>供应商名称</td>
					<td>供应商描述</td>
					<td>联系人</td>
					<td>供应商电话</td>
					<td>供应商传真</td>
					<td>供应商名称</td>
					<td>供应商地址</td>
				</tr>
				<c:forEach items="${pageBean.data }" var="accountDetail">
					<tr>
						<td>${providerDetail.providerNamed }</td>
						<td>${providerDetail.providerDetail }</td>
						<td>${provideretail.contact }</td>
						<td>${provideretail.telephone }</td>
						<td>${providerDetail.facsimile }</td>
						<td>${providerDetail.address }</td>
						<td><a href="provider?cmd=getAllProvider&&action=update&&providerId=${providertDetail.providerId }">修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<form id="form" action="provider?cmd=getPageBean">
		<label class="input-button">跳转到</label>
    	<select name="p" onchange="getPageBeanByP();">
    		<c:forEach var="j" begin="1" end="${pageBean.getPagetotal()}">
    			<c:if test="${pageBean.getP() == j}">
    				<option selected="selected" value="${j}">第${j}页</option>
    			</c:if>
    			<c:if test="${pageBean.getP() != j}">
    				<option value="${j}">第${j}页</option>
    			</c:if>
    		</c:forEach>
    	</select>
    	<a class="input-button" href="provider?cmd=getPageBean&p=${pageBean.p - 1 }">上一页</a>
    	<a class="input-button" href="provider?cmd=getPageBean&p=${pageBean.p + 1 }">下一页</a>
    </form>
    
 </div>
	<script type="text/javascript">
		function getPageBeanByP() {
			var form = document.getElementById("form");
			form.submit();
		}
	</script>
</body>
</html>