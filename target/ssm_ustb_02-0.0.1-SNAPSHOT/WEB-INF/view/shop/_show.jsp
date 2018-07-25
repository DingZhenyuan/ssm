<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<A href="${applicationScope.rootPath }/shop/tosave">注册店铺</A>
<hr>
<table width="100%">
	<tr>
		<th>编号</th>
		<th>图片</th>
		<th>名称</th>
		<th>地址</th>
		<th>权重</th>
		<th>店主</th>
		<th>区域</th>
		<th>类型</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${requestScope.shopList}" var="shop">
	<tr>
		<td>${shop.shopId }</td>
		<td><img width="50px" height="50px" src="${applicationScope.rootPath }/resources/${shop.shopImg }"></td>
		<td>${shop.shopName }</td>
		<td>${shop.shopAddr }</td>
		<td>${shop.priority }</td>
		<td>${shop.owner.name }</td>
		<td>${shop.area.areaName }</td>
		<td>${shop.shopCategory.shopCategoryName }</td>
		<td><a href="${applicationScope.rootPath }/shop/toupdate?shopId=${shop.shopId }">修改</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>