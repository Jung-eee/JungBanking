<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 신청</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/account.css'/>" />
</head>
<body>
<jsp:include page="../incl/header.jsp" />
<div class="section">
<form action="add_account" method="post">
  <div class="container">
	<div class="popup-wrap" id="popup"> 
    <div class="popup">	
      <div class="popup-head">	
          <span class="head-title">계좌신청</span>
      </div>
      <div class="popup-body">	
        <div class="body-content">
          <div class="body-titlebox">
            <span>이름 :</span>
			 <span>${customer.name}</span>
          </div>
          <div class="body-contentbox boxs">
            <p> 계좌를 신청하시겠습니까?</p>
          </div>
        </div>
      </div>
      <div class="popup-foot">
        <input type="submit" class="pop-btn confirm" id="confirm" value="신청하기">
      </div>
    </div>
   </div>
</div>
</form>
</div>
</body>
</html>