<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금하기</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/account.css'/>" />
</head>
<body>
<jsp:include page="../incl/header.jsp" />
<div class="section">
<form action="deposit" method="post">
  <div class="container">
	<div class="popup-wrap" id="popup"> 
    <div class="popup">	
      <div class="popup-head">	
          <span class="head-title">계좌번호</span>
      </div>
      <div class="popup-body">	
        <div class="body-content">
          <div class="body-titlebox">
           <select name="accountNum" class="deposit_acc">
			<c:forEach var="item" items="${accountList}">
				<option>${item.accountNum}</option>
			</c:forEach>
		</select>
          </div>
          <div class="body-contentbox">
            <span>금액</span>
		<input type="text" name="depositMoney" required="required" class="depositMoney">
          </div>
        </div>
      </div>
      <div class="popup-foot">
        <input type="submit" class="pop-btn confirm" id="confirm" value="입금하기">
      </div>
    </div>
   </div>
</div>
</form>
</div>
</body>
</html>