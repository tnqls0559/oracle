<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="page_isErrorPage_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류를 발생시키는 페이지</title>
</head>
<body>
<%
   try{
   String str=null;
   out.print(str.toString());
   }catch(Exception e){
	   out.print("null 포인트 오류가 발생하였습니다.");
   }
%>
</body>
</html>