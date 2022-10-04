<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JungBanking</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>" />
</head>
<body>
<jsp:include page="./incl/header.jsp" />
<div class="container">
	<div class="box">
	<div class="flex-top">
		<div class="main">
			<a href='<c:url value='/account/add_account'/>'>
			<div class="card">
              <span class="icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class=" ">
                    <g fill="none" fill-rule="evenodd"><path fill="#C370E0" d="M4 20.5v-17a2 2 0 012-2h12a2 2 0 012 2v17a2 2 0 01-2 2H6a2 2 0 01-2-2"></path><path fill="#FFF" d="M10.5 7.5h3v-3h-3z"></path><path fill="#2272E6" d="M17 23a6 6 0 100-12 6 6 0 000 12"></path><path fill="#FFF" d="M17.38 13.89l.757 1.531a.417.417 0 00.315.228l1.69.246c.343.05.48.471.232.713L19.15 17.8a.418.418 0 00-.121.37l.289 1.684a.418.418 0 01-.606.44L17.2 19.5a.418.418 0 00-.39 0l-1.511.795a.418.418 0 01-.607-.44l.289-1.684a.415.415 0 00-.12-.37l-1.223-1.192a.418.418 0 01.232-.713l1.69-.246a.417.417 0 00.315-.228l.756-1.532a.417.417 0 01.749 0"></path></g>
                  </svg>
                  </g>
                </svg>
              </span>
            </div>
            <span class="seven_span">계좌신청</span>
			</a>
		</div>
		<div class="main">
		   <a href='<c:url value='/account/balance'/>'>
            <div class="find">
              <span class="icon">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class=" ">
                  <g fill="none" fill-rule="evenodd"><path fill="#FFB131" d="M3.5 18.205h16V9.858h-16z"></path><path fill="#FFCF58" d="M2 21.069h18v-3H2zM11.5 7.932a1.5 1.5 0 110-3 1.5 1.5 0 010 3m8.992-1.923L11.5.932 2.508 6.009a1 1 0 00-.508.87v3.417h19V6.88a1 1 0 00-.508-.871"></path><path fill="#4E5968" d="M14.5 17.5c0-1.378 1.121-2.5 2.5-2.5s2.5 1.122 2.5 2.5S18.379 20 17 20a2.503 2.503 0 01-2.5-2.5zm8.707 4.793l-2.406-2.407A4.467 4.467 0 0021.5 17.5c0-2.48-2.019-4.5-4.5-4.5a4.505 4.505 0 00-4.5 4.5c0 2.481 2.019 4.5 4.5 4.5.879 0 1.692-.263 2.387-.7l2.406 2.407 1.414-1.414z"></path></g>
                </svg>
              </span>
            </div>
            <span class="seven_span">계좌조회</span>
		   </a>
		</div>
		</div>
		<div class="bottom-flex">
		<div class="main">
		  <a href='<c:url value='/account/deposit'/>'>
		    <div class="service">
              <span class="icon">
               <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class=" "><g fill="none" fill-rule="evenodd"><path stroke="#4E5968" stroke-linecap="round" stroke-width="2" d="M6.93 1.8v2M17.07 1.8v2"></path><path fill="#E2E5E8" d="M19.7 2.8H4.3a2 2 0 00-2 2v15.4a2 2 0 002 2h15.4a2 2 0 002-2V4.8a2 2 0 00-2-2"></path><path stroke="#15C07E" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.8" d="M16.248 9.57L14.4 16.28c-.056.201-.341.201-.397 0l-1.806-6.56c-.055-.2-.341-.2-.396 0l-1.806 6.56c-.055.201-.341.201-.396 0L7.752 9.57M15.303 13H18M8.697 13H5.999"></path></g></svg>
              </span>
            </div>
            <span class="seven_span">입금</span>
		  </a>
		</div>
		<div class="main">
		   <a href='<c:url value='/account/transfer'/>'>
		    <div class="atm">
              <span class="icon">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class=" "><g fill="none" fill-rule="evenodd"><path fill="#15C07E" d="M20 21.846H4a1 1 0 01-1-1v-18h18v18a1 1 0 01-1 1"></path><path stroke="#4E5968" stroke-linecap="round" stroke-width="1.8" d="M3 2.846h18"></path><path stroke="#FFF" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.6" d="M16.248 9.07L14.4 15.78c-.056.201-.341.201-.397 0l-1.806-6.56c-.055-.2-.341-.2-.396 0l-1.806 6.56c-.055.201-.341.201-.396 0L7.752 9.07M15.303 12.5h2.698M8.697 12.5H5.999"></path></g></svg>
              </span>
            </div>
            <span class="seven_span">이체</span>
		   </a>
		</div>
		</div>
	</div>
</div>
</body>
</html>