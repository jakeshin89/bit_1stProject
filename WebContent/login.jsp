<%@page import="vo.UsersVO"%>
<%@page import="dao.UsersDAO_Oracle"%>
<%@page import="dao.UsersDAO"%>
<%@page import="service.UsersService_Imp"%>
<%@page import="service.UsersService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>

<body>
<h3> login 처리</h3>

<!-- java code 영역, 서비스 준비 -->

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	UsersDAO dao = new UsersDAO_Oracle();
	UsersService service = new UsersService_Imp(dao);

	UsersVO vo = new UsersVO();
	vo.setId(id);
	vo.setPassword(pw);

	UsersVO data = service.login(vo);

%>

입력정보 : <%= id %> <%= pw %>
<br/>
로그인 정보 : <%= data %>

<!-- %=은 출력을 의미 -->

<p>
<a href="askcody_index.html">홈으로</a>
</p>
</body>
</html>