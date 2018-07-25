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

<form action="${applicationScope.rootPath }/shop/updateshop" method="post">
<input type="hidden" name="shopId" value="${requestScope.shop.shopId }">
<input type="hidden" name="srcShopName" value="${requestScope.shop.shopName }">
店铺名称：<input type="text" name="shopName" value="${requestScope.shop.shopName }"><br>
店铺地址：<input type="text" name="shopAddr" value="${requestScope.shop.shopAddr }"><br>
店铺手机：<input type="text" name="phone" value="${requestScope.shop.phone }"><br>
店铺权重：<input type="text" name="priority" value="${requestScope.shop.priority }"><br>
店铺类型：<select name="shopCategory.shopCategoryId">
	<c:forEach items="${requestScope.categoryList }" var="category">
	<c:choose>
	<c:when test="${ category.shopCategoryId eq requestScope.shop.shopCategory.shopCategoryId}">
	<option value="${category.shopCategoryId }" selected="selected">${category.shopCategoryName }</option>
	</c:when>
	<c:otherwise>
	<option value="${category.shopCategoryId }">${category.shopCategoryName }</option>
	</c:otherwise>
	</c:choose>
	</c:forEach>
</select>
<br>
店铺区域：<select name="area.areaId">
	<c:forEach items="${requestScope.areaList }" var="area" >
	<c:choose>
	<c:when test="${area.areaId eq requestScope.shop.area.areaId }">
	<option value="${area.areaId }" selected="selected">${area.areaName }</option>
	</c:when>
	<c:otherwise>
	<option value="${area.areaId }" >${area.areaName }</option>
	</c:otherwise>
	</c:choose>
	</c:forEach>
</select>
<br>
店铺简介：<textarea rows="5" cols="20" name="shopDesc">${requestScope.shop.shopDesc }</textarea><br>
<input type="submit" value="提交">
</form>
</body>
</html>