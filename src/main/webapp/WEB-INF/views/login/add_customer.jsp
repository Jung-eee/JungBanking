<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>" />
</head>
<body>
<jsp:include page="../incl/header.jsp" />
<div class="section" style="padding-top: 1px;">
<div class="container">
<h1>Sign Up</h1>
<form method="post" action="add_customer">
	<div class="text_form">
	<input type="text" name="email1" class="in_form" placeholder="email">
	@
	<select name="email2" class="sel">
		<option selected="selected">naver.com</option>
		<option>kakao.com</option>
		<option>google.com</option>
	</select><br>
	</div>
	<div class="text_form">
	<input type="password" name="passwd" required="required" maxlength="20" class="in_form" placeholder="비밀번호"><br>
	</div>
	<div class="text_form">
	<input type="text" name="name" class="in_form" placeholder="이름"><br>
	</div>
	<div class="text_form">
	<input type="text" name="ssn" oninput="autoHyphenSsn2(this)" maxlength="14" class="in_form" placeholder="1234567-1234567">
	<br>
	</div>
	<div class="text_form">
	<input type="text" name="phone" oninput="autoHyphen2(this)" maxlength="13" class="in_form" placeholder="010-1234-1234">
	<input type="submit" value="회원가입" class="btn">
	</div>
</form>
</div>
</div>
<script type="text/javascript" src="<c:url value='/resources/js/common.js'/>"></script>
</body>
</html>