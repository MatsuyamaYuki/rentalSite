<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登録確認画面</title>
</head>
<body>
<div align="center">
<h1>送信内容確認画面</h1>
	<hr />
	<form:form modelAttribute="UserInformationModel">
	<table width="1000">
	<tr>
		<td>お名前</td>
		<td> UserInformationModel.getUserName();</td>
	</tr>
	<tr>
		<td>性別</td>
		<td><c:out value="${gender }" /></td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td>
			<c:out value="${year}年" />
			<c:out value="${month}月" />
			<c:out value="${day}日" />
		</td>
	</tr>
		<tr>
		<td>メールアドレス</td>
		<td><c:out value="${userMail}" /></td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td>${userPassword.length()}文字 </td>
	</tr>

	<tr>
		<td>プラン</td>
		<td>
			<table border="1">
				<tr>
					<th>プラン名</th><th>金額</th><th>上限レンタル枚数</th>
				</tr>
				<c:if test="${plan == 'try' }">
				<tr>
					<td>お試し</td><td>315円</td><td>2枚</td>
				</tr>
				</c:if>
				<c:if test="${plan == 'bronze' }">
				<tr>
					<td>Bronze</td><td>1050円</td><td>6枚</td>
				</tr>
				</c:if>
				<c:if test="${plan == 'slver' }">
				<tr>
					<td>Silver</td><td>2100円</td><td>12枚</td>
				</tr>
				</c:if>
				<c:if test="${plan == 'gold' }">
				<tr>
					<td>Gold</td><td>5250</td><td>無制限</td>
				</tr>
				</c:if>
			</table>
		</td>
	</tr>
	<tr>
		<td>郵便番号</td>
		<td><c:out value="〒${zip.substring(0,3)}-${zip.substring(3,7) }" /> </td>
	</tr>
	<tr>
		<td>住所</td>
		<td><c:out value="${ userAddress}" /></td>
	</tr>
		<tr>
		<td>電話番号</td>
		<td><c:out value="${userTel}"  /></td>
	</tr>
	<tr>
		<td>カード名義</td>
		<td><c:out value="${cardName}"/></td>
	</tr>
	<tr>
		<td>カード番号</td>
		<td><c:out value="${cardNumber}"/></td>
	</tr>
	<tr>
		<td>カード期限</td>
		<td><c:out value="${cardMonth}/20${cardYear }"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="登録" onclick="/registerAccount" /></td>
	</tr>
	</table>
	</form:form>
	</div>

</body>
</html>