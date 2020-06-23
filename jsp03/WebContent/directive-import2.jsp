<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %><!-- import속성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
   java.util.Calendar cal = java.util.Calendar.getInstance();
%>
오늘은
<%=cal.get(Calendar.YEAR) %>년
<%=cal.get(Calendar.MONTH)+1 %>월
<%=cal.get(Calendar.DATE) %>일
</body>
</html>