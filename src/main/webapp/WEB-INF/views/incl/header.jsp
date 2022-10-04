<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="head">
   <header>
   	  <h2><a href='<c:url value='/main'/>'><img alt="bank" src='<c:url value="/resources/img/bank.png"/>'></a></h2>
         <nav>
            <ul>
               <li><a href='<c:url value='/account/add_account'/>'>계좌신청</a></li>
               <li><a href='<c:url value='/account/balance'/>'>계좌조회</a></li>
               <li><a href='<c:url value='/account/deposit'/>'>입금</a></li>
               <li><a href='<c:url value='/account/transfer'/>'>이체</a></li>
               <c:choose>
               	<c:when test="${not empty customer}">
               		<li><a href='<c:url value='#'/>'>${customer.name}님</a></li>
               		<li><a href='<c:url value='/login/logout'/>'>로그아웃</a></li>
               	</c:when>
               	<c:otherwise>               	
	               <li><a href='<c:url value='/login/login'/>'>로그인</a></li>
               	</c:otherwise>
               </c:choose>
             </ul>
           </nav>
    </header>
 </div>
