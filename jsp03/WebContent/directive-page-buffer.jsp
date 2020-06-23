<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="16kb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buffer사이즈 지정</title>
</head>
<body>
Today is:<%=new java.util.Date() %><br>
<%=out.getBufferSize() %><!-- 페이지의 지정 버퍼사이즈 출력 -->
</body>
</html>