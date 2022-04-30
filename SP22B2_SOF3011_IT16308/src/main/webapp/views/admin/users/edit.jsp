<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<form
action="/SP22B2_SOF3011_IT16308/users/update?id=${user.id}" 
method="post">
		<div>
			<label>Họ và Tên</label> <input type="text" name="hoTen" value="${user.hoTen} ">
		</div>

		<div>
			<label>Địa chỉ</label> <input type="text" name="diaChi" value="${user.diaChi}">
		</div>

		<div>
			<label>Email</label> <input type="email" name="email" value="${user.email}">
		</div>

		
		<div>
			<label>SDT</label> <input type="text" name="sdt" value="${user.sdt}">
		</div>
		<button>Cap Nhat</button>
		<button type="reset">Xóa form</button>
	</form>