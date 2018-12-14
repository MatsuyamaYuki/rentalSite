<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>レンタルサイト 在庫削除</title>
<style type="text/css">
.error{
  color:#FF0000;
}
</style>
</head>
<body>
 <h1>在庫削除</h1>
 <hr/>
 <p>下記の在庫を削除します。</p>
 <form:form>
   <table>
   <tr>
     <td>在庫ID</td>
     <td>
       <c:out value="${deleteStockModel.stock_id}"/>
       <input type="hidden" value="${deleteStockModel.stock_id}" name="stock_id"/>
     </td>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td>商品名</td>
     <td><c:out value="${deleteStockData.stock_name}"/></td>
   </tr>
   <tr>
     <td>個数</td>
     <td><c:out value="${deleteStockData.stock_count}"/></td>
   </tr>
   <tr>
     <td>分類</td>
     <td><c:out value="${deleteStockData.stock_type}"/></td>
   </tr>
   <tr>
     <td>アーティスト</td>
     <td><c:out value="${deleteStockData.artist}"/></td>
   </tr>
   <tr>
     <td>監督</td>
     <td><c:out value="${deleteStockData.manager}"/></td>
   </tr>
   <tr>
     <td colspan="3">
       <input type="submit" value="削除"/>
     </td>
   </tr>
   </table>
   </form:form>
   <p class="error">${errorMessage}</p>
</body>
</html>