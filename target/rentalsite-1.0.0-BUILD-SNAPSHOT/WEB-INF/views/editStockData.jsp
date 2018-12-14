<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>レンタルサイト 在庫変更</title>
<style type="text/css">
.error{
  color:#FF0000;
}
</style>
</head>
<body>
 <h1>在庫変更</h1>
 <hr/>
 <form:form modelAttribute="stockModel">
  <table>
  <tr>
    <td>在庫ID</td>
    <td>
      <c:out value="${stockModel.stock_id}"/>
      <input type="hidden" value="${stockModel.stock_id}" name="stock_id"/>
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>商品名</td>
    <td><form:input path="stock_name" size="50"/></td>
    <td><form:errors path="stock_name" element="div" cssClass="error"/></td>
  </tr>
  <tr>
    <td>アーティスト</td>
    <td><form:input path="artist" size="50"/></td>
    <td><form:errors path="artist" element="div" cssClass="error"/></td>
  </tr>
  <tr>
    <td>監督</td>
    <td><form:input path="manager" size="50"/></td>
    <td><form:errors path="manager" element="div" cssClass="error"/></td>
  </tr>
  <tr>
  <td colspan="3">
    <input type="submit" value="変更" name="edit"/>
    <input type="submit" value="リセット" name="reset"/>
    </td>
  </tr>
  </table>
  </form:form>
  <p class="error">${errorMessage}</p>
</body>
</html>