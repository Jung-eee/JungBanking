<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>" />
</head>
<body>
<jsp:include page="../incl/header.jsp" />
<div class="section" style="padding-top: 1px;">
<div class="container">
<h1>Login</h1>
<form action="login" method="post">
    <!-- email input -->
    <div class="first-input input__block first-input__block">
       <input type="email" placeholder="Email" class="input" name="email" id="email"   />
    </div>
    <!-- password input -->
    <div class="input__block">
       <input type="password" placeholder="Password" name="passwd" class="input" id="password"    />
    </div>
	<input type="submit" value="로그인" class="login_su">
	<a href='<c:url value='/login/add_customer'/>'>회원가입</a>
</form>
</div>
</div>
</body>
</html>