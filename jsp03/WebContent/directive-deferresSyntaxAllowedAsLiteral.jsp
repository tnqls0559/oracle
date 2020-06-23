<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page deferredSyntaxAllowedAsLiteral="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력</title>
</head>
<body>
<%
   Member m = new Member();
   m.setName("홍길동");
%>
<%-- 변수선언 --%>
<%-- 변수 m을 선언하고 스크립틀릿에서 생성한 Member를 대입 --%>
<c:set var="m" value="<%=m %>"/><%-- m=new Member() --%>
${m.name}<br>
<c:set var="name" value="#{m.name}"/><%-- #{m.name} m.getName() --%>
<%m.setName("일지매"); %>
${name}<%-- EL표현식 --%>
</body>
</html>