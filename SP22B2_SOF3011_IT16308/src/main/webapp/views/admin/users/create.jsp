<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${!empty sessionScope.error}">
	<div class=" alert alert-danger">
	${sessionScope.error}
	</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>

<form action="/SP22B2_SOF3011_IT16308/users/store" method="post">
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
	<button>Them</button>
	<button type="reset">Xóa form</button>
</form>