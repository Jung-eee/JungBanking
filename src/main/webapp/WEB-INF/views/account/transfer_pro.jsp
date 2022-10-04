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
		<form action="transfer_pro" method="post">
			<div class="container">
				<div class="popup-wrap" id="popup">
					<div class="popup">
						<div class="popup-head">
							<span class="head-title">이체 확인</span>
						</div>
						<div class="popup-body">
							<div class="body-content">
								<div class="body-contentbox boxs conbox">
									<p class="transfer">보내는 사람</p>
									<span class="tran">${customer.name}</span><span>${sendingAccount}</span>
									<input hidden name="sendingAccount" value="${sendingAccount}" />
									<p class="transfer">받는 사람</p>
									<span class="tran">${reCustomer.name}</span><span>${receivingAccount}</span>
									<p class="transfer">보내는 금액</p>
									<p class="tran">${transferMoney}</p><br>
									<input hidden name="transferMoney" value="${transferMoney}" />
									<input hidden name="receivingAccount" value="${receivingAccount}" />
										 <span>맞으면 비밀번호 입력해주세요.</span> <input
										type="password" name="passwd" required="required">
								</div>
							</div>
						</div>
						<div class="popup-foot">
							<input type="submit" class="pop-btn confirm" id="confirm" value="이체하기">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>