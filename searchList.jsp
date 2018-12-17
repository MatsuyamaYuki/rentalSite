<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
	.menu{display:block;
				width:300px;
				padding-top:10px;
				padding-bottom:10px;
				text-align:center;
				background:blue;
				border-color:#aaaaaa #444444 #444444 #aaaaaa;
				text-decoration:none;
				font-color:#444444;}
	.menu:hover{background:#ffcccc;}
	.menu:link{color:#000000;}
	.menu:visited{color:#000000;}
	table{text-align:center;}
	.error{color:#ff0000;}
	td{width:200px;}

</style>
<title>検索</title>
</head>
<body>
<center>
<h1>検索</h1>
<table>
	<tr>
			<td><a href="#" class="menu">TOP</a></td>
			<td><a href="#" class="menu">カート</a></td>
	</tr>
</table>
<hr/>
<div>
<form:form modelAttribute="stockModel">
	<form:errors path="*" element="div" cssClass="error"/>
	<form:radiobutton path="stockType" label="CD" value="1" checked="true"/>
	<form:radiobutton path="stockType" label="DVD" value="2" />
	<form:radiobutton path="stockType" label="Blu-ray" value="3" />
	<br/>
	<form:input  path="stockName" size="50" />&nbsp;
	<input type="submit" value="検索"/>
</form:form>
</div>
<hr />
<div>
<form:form modelAttribute="stockModel">
<c:out value="${title }"/>
<c:if test="${searchList.size() >0}">
<hr />
<table border="1" >
	<tr><th>タイトル</th><th>アーティスト</th><th>在庫</th><th>レンタル</th></tr>
		<c:forEach var="stock" items="${searchList}">
				<tr>
					<td><c:out value="${stock.name }"/></td>
					<td><c:out value="${stock.artist }"/></td>
					<td><c:out value="${stock.stock_count}"/>枚</td>
					<td><form:checkbox path="stockName" value="${stock.name }" /></td>
				</tr>
			</c:forEach>
</table>
<input type="submit" value="カートに入れる"/>
</c:if>
<c:if test="${searchList.size()==0}">
<hr />
<p>
	no data...
</p>
</c:if>
</form:form>
</div>
</center>
</body>
</html>