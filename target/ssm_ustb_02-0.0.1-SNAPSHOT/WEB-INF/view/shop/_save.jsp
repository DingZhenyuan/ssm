<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${applicationScope.rootPath }/shop/save" 
		method="post" enctype="multipart/form-data">
店铺名称：<input type="text" name="shopName"><br>
店铺地址：<input type="text" name="shopAddr"><br>
店铺手机：<input type="text" name="phone"><br>
店铺权重：<input type="text" name="priority"><br>
店铺类型：<select name="shopCategory.shopCategoryId">
	<c:forEach items="${requestScope.categoryList }" var="category">
	<option value="${category.shopCategoryId }">${category.shopCategoryName }</option>
	</c:forEach>
</select>
<br>
店铺区域：<select name="area.areaId">
	<c:forEach items="${requestScope.areaList }" var="area" >
	<option value="${area.areaId }">${area.areaName }</option>
	</c:forEach>
</select>
<br>
店铺图片：<input type="file" name="upShopImg"><br>
店铺简介：<textarea rows="5" cols="20" name="shopDesc"></textarea><br>
<input type="submit" value="提交">
</form>
</body>
</html>