
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16308_Register</title>
</head>
<body>
	<form action="/SP22B2_SOF3011_IT16308/RegisterServlet" method="post">
		<div>
			<label>Họ và Tên</label> <input type="text" name="hoTen">
		</div>

		<div>
			<label>Địa chỉ</label> <input type="text" name="diaChi">
		</div>

		<div>
			<label>Email</label> <input type="email" name="email">
		</div>

		<div>
			<label>Password</label> <input type="password" name="password">
		</div>
		<div>
			<label>SDT</label> <input type="text" name="sdt">
		</div>
		
		
		 
		
		<button>Đăng Ký</button>
		<button type="reset">Xóa form</button>
	</form>
</body>
</html>