<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
.error{
  color:#FF0000;
}
</style>
<title>レンタルサイト 在庫変更/削除</title>
</head>
<body>
  <h1>在庫変更/削除</h1>
  <hr/>
  <p class="error">${errorMessag }</p>
  <form:errors path="*" element="div" cssClass="error"/>
   <table border="1">
   <tr>
     <th>在庫ID</th>
     <th>商品名</th>
     <th>在庫数</th>
     <th>新作旧作</th>
     <th>分類</th>
     <th>アーティスト</th>
     <th>監督</th>
     <th>&nbsp;</th>
     <th>&nbsp;</th>
   </tr>
   <c:forEach var="sto" items="${changeStockList}">
   <form:form modelAttribute="employeeModel">
   <tr>
     <td><c:out value="${sto.stock_id}"/></td>
     <td width="150"><c:out value="${sto.stock_name}"/></td>
     <td width="100"><c:out value="${sto.stock_count}"/></td>
     <td width="150"><c:out value="${sto.artist}"/></td>
     <td width="150"><c:out value="${sto.manager}"/></td>

     <td><a href="edit?paramId=${sto.stock_id}">変更</a></td>
     <td><a href="delete?paramId=${sto.stock_id}">削除</a></td>
   </tr>
   </form:form>
   </c:forEach>
   </table>
</body>
</html>