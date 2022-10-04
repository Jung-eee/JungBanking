<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체 확인</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/main.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/account.css'/>" />
</head>
<body>
	<jsp:include page="../incl/header.jsp" />
	<div class="section">
		<div class="container">
			<div class="popup-wrap" id="popup">
				<div class="popup">
					<div class="popup-head">
						<span class="head-title">이체 성공</span>
					</div>
					<div class="popup-body">
						<div class="body-content">
							<div class="body-contentbox boxs">
								<p class="transfer">계좌</p>
								<span class="tran">${account.accountNum}</span>
								<p class="transfer">잔액</p>
								<span>${account.balance}원</span>
							</div>
						</div>
					</div>
					<div class="popup-foot">
						<input type="submit" class="pop-btn confirm" id="confirm"
							value="메인" onclick="location='/jungBanking/main'">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>