
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Hình Chữ Nhật</title>
</head>
<body>
	<div class="container">
		<form action="/SP22B2_SOF3011_IT16308/HinhChuNhatServlet"
			method="post">
			<h4>Thông tin hình chữ nhật</h4>
			<div class="row">
				<div class="col-5">
					<label>Chiều rộng</label>
				</div>
				<div class="col-7">
					<input type="number" name="chieu_rong">
				</div>

				<input>
			</div>

			<div class="row">
				<div class="col-5">
					<label>Chiều dài</label>
				</div>
				<div class="col-7">
					<input type="number" name="chieu_dai">
				</div>

				<input>
			</div>
			<button>Tính</button>
		</form>
	</div>
</body>
</html>