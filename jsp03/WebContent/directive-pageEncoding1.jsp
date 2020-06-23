<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageEncoding:현재페이지의 문자셋 설정</title>
</head>
<body>
<%@ page info="Date 클래스를 이용한 날짜 출력하기" %>
Today is : <%=new java.util.Date() %>
<%=getServletInfo() %>
</body>
</html><!-- info속성에 저장된 내용 출력 -->