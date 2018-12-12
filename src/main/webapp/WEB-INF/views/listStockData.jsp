<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Rental Site</title>
</head>
<body>
<h1>在庫一覧</h1>
<hr/>
<p>${message}</p>
<hr/>
<c:if test="${stockList!=null}">
<table border="1">
  <tr><th>在庫 ID</th><th>商品名</th><th>在庫数</th><th>新作旧作</th>
  <th>種類</th><th>アーティスト名</th><th>監督名</th></tr>
   <c:forEach var="sto" items="${stockList}">
     <tr>
       <td><c:out value="${sto.stock_id}"/></td>
       <td><c:out value="${sto.stock_name}"/></td>
       <td><c:out value="${sto.new_or_old}"/></td>
       <td><c:out value="${sto.stock_count}"/></td>
       <td><c:out value="${sto.stock_type}"/></td>
       <td><c:out value="${sto.artist}"/></td>
       <td><c:out value="${sto.manager}"/></td>
     </tr>
     </c:forEach>
</table>
</c:if>
<c:if test="${employeesList==null}">
   <p>no data...</p>
</c:if>
</body>
</html>