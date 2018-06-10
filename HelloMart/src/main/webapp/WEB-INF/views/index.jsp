<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloMart</title>
</head>
<body>
<a href="join">join</a> -- 회원가입<br/>
<a href="login">login</a> -- 로그인<br/>
<a href="member/page">member</a> -- MEMBER, SELLER 계정만 접근가능<br/>
<a href="seller/page">seller</a> -- SELLER 계정만 접근가능<br/>
<a href="admin/page">admin</a> -- ADMIN 계정만 접근가능<br/>
<a href="authenticated/page?str=한글이여">authenticated</a> -- 로그인된 유저만 접근가능<br/>
<a href="logout">logout</a> -- 로그아웃<br/>
</body>
</html>