<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jstl 라이브러리를 이용한 반복출력 -->
<!-- var변수 선언, begin 시작 값, end 종료값 varStatus=상태표시 변수 -->
<c:forEach var="k" begin="1" end="10" varStatus="i">
  <c:out value="${k}"/>-${i.count} &nbsp; &nbsp;
</c:forEach>
<br>
<!-- 반복 step증가치 -->
<c:forEach var="k" begin="1" end="10" step="2">
   <c:out value="${k}"/>  &nbsp;  &nbsp;
</c:forEach>
<br>
<c:forEach var="k" begin="1" end="10">
  <c:if test="${k%2==0}"><c:out value="${k}"/></c:if>
</c:forEach>
</body>
</html>