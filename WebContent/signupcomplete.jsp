<%@page import="vo.UsersVO"%>
<%@page import="dao.UsersDAO_Oracle"%>
<%@page import="dao.UsersDAO"%>
<%@page import="service.UsersService_Imp"%>
<%@page import="service.UsersService"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Complete</title>
</head>

<body>
<h3>회 원 가 입 처 리</h3>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String role = request.getParameter("role");
	
	UsersDAO dao = new UsersDAO_Oracle();
	UsersService service = new UsersService_Imp(dao);
	
	UsersVO vo = new UsersVO();
	vo.setId(id);
	vo.setPassword(pw);
	vo.setName(name);
	vo.setRole(role);
	
	int c = service.addUsers(vo);
	
%>

입력정보 : <%= id %> / <%= pw %> / <%= name %> / <%= role %>
<br/>

<%
	if(c == 0){
%>

<h4> 회 원 가 입 실 패 </h4>

<%
	} else {
%>
<h4>축하합니다! <br/> 회원가입이 왼료되었습니다.</h4>
<%
	}
%>


<a href="index.html"></a>
</body>
</html>