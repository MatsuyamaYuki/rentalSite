<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新規アカウント作成</title>
<style type="text/css">
.error{
	color:#FF0000
}
</style>
</head>
<body>
	<div align="center">
	<h1>新規アカウント作成</h1>
	<hr />
	<form:form modelAttribute="UserInformationModel">
	<table width="1000">
	<tr>
		<td>お名前</td>
		<td><form:input path="userName" size="15" /></td>
		<td><form:errors path="userName" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>性別</td>
		<td><form:radiobutton path="gender" value="男" />男
		<form:radiobutton path="gender" value="女" />女</td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td>
			<form:select path="year" items="${year}" itemLabel="label" itemValue="data" />年&nbsp;
			<form:select path="month" items="${month}" itemLabel="label" itemValue="data" />月&nbsp;
			<form:select path="day" items="${day}" itemLabel="label" itemValue="data" />日&nbsp;
		</td>
	</tr>
		<tr>
		<td>メールアドレス</td>
		<td><form:input path="userMail" size="50" /></td>
		<td><form:errors path="userMail" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td><form:password path="userPassword" size="50" /></td>
		<td><form:errors path="userPassword" element="div" cssClass="errror" /></td>
	</tr>
	<tr>
		<td>プラン</td>
		<td>
			<table border="1">
				<tr>
					<th>プラン名</th><th>金額</th><th>上限レンタル枚数</th><th>備考</th>
				</tr>
				<tr>
					<td><form:radiobutton path="plan" name="plan" value="try" checked="checked"/>お試し</td>
					<td>315円</td><td>2枚</td><td>新規登録月の月末限定</td>
				</tr>
				<tr>
					<td><form:radiobutton path="plan" name="plan" value="bronze" />Bronze</td>
					<td>1050円</td><td>6枚</td><td rowspan="3">3ヶ月間連続半分以下しか<br />レンタルしなかったら<br />翌月の枚数が2枚増えます</td>
				</tr>
				<tr>
					<td><form:radiobutton path="plan" name="plan" value="silver" />Silver</td>
					<td>2100円</td><td>12枚</td>
				</tr>
				<tr>
					<td><form:radiobutton path="plan" name="plan" value="gold" />Gold</td>
					<td>5250</td><td>無制限</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>郵便番号</td>
		<td>〒<form:input path="zip" size="7" /></td>
		<td><form:errors path="zip" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>住所</td>
		<td><form:input path="userAddress" size="50" /></td>
		<td><form:errors path="userAddress" element="div" cssClass="error" /></td>
	</tr>
		<tr>
		<td>電話番号</td>
		<td><form:input path="userTel" size="10" /></td>
		<td><form:errors path="userTel" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>カード名義</td>
		<td><form:input path="cardName" size="15" /></td>
	</tr>
	<tr>
		<td>カード番号</td>
		<td><form:input path="cardNumber" size="16" /></td>
	</tr>
	<tr>
		<td>カード期限</td>
		<td><form:input path="cardMonth" size="2" /> /20<form:input path="cardYear" size="2" /></td>
	</tr>
	<tr>
		<td><input type="submit" /></td>
	</tr>
	</table>
	</form:form>
	</div>

</body>
</html>