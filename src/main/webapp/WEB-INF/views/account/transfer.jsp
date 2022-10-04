<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체</title>
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
		<form action="transfer" method="post">
			<div class="container">
				<div class="popup-wrap" id="popup">
					<div class="popup">
						<div class="popup-head">
							<span class="head-title">이체</span>
						</div>
						<div class="popup-body">
							<div class="body-content">
								<div class="body-contentbox boxs">
									<span class="tran">보내는 계좌</span> <select name="sendingAccount">
										<c:forEach var="item" items="${accountList}">
											<option>${item.accountNum}</option>
										</c:forEach>
									</select> <br> <span class="tran">금액</span> <input type="text"
										name="transferMoney" oninput="inputNumberFormat(this)"
										required="required"><br> <span class="tran">받는 계좌</span> <input
										type="text" name="receivingAccount"
										oninput="autoHyphenAccountNum(this)" maxlength="10"
										required="required" placeholder="xxx-xx-xxx">
								</div>
							</div>
						</div>
						<div class="popup-foot">
							<input type="submit" class="pop-btn confirm" id="confirm"
								value="이체하기">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript"
		src="<c:url value='/resources/js/common.js'/>"></script>
</body>
</html>