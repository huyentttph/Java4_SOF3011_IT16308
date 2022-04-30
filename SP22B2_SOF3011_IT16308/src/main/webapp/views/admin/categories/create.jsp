<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:if test="${!empty sessionScope.error}">
	<div class=" alert alert-danger">
	${sessionScope.error}
	</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST"
		action="/SP22B2_SOF3011_IT16308/categories">
		<div>
			<label>Tên danh mục</label>
			<input class="form-control" type="text" name="ten" />
		</div>
		<div>
			<label>Người tạo</label>
			<select name="user_id" class="form-control">
				<c:forEach items="${ ds }" var="user">
					<option value="${ user.id }">
						${ user.hoTen }
					</option>
				</c:forEach>
			</select>
		</div>
		
		<button>Thêm mới</button>
	</form>
</body>
</html>