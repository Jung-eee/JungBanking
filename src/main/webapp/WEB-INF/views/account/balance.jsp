<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 조회</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/account.css'/>" />
</head>
<body>
<jsp:include page="../incl/header.jsp" />
<div class="section">
<h2 class="cus_bal">${customer.name}님의 계좌 조회 입니다</h2>
<table>
   <tr>
	<th style="width: 10%;">No</th>
	<th style="width: 30%;">계좌번호</th>
	<th style="width: 30%;">잔고</th>
	<th style="width: 30%;">계좌 발급날짜</th>
   </tr>
	<c:forEach var="i" begin="0" end="${fn:length(accountList) - 1}">
		<tr>
		  <td>${i + 1}</td>
		  <td>${accountList[i].accountNum}</td>
		  <td>${accountList[i].balance}</td>
		  <td>${accountList[i].regDate}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>