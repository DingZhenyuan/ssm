<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>/resources/">
	<title>企业信息管理系统</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<frameset rows="98,*,8" frameborder="no" border="0" framespacing="0">
  <frame src="${applicationScope.rootPath }/manager/top" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="${applicationScope.rootPath }/manager/center" name="mainFrame" id="mainFrame" />
  <frame src="${applicationScope.rootPath }/manager/down" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes><body>
</body>
</noframes>
</html>
