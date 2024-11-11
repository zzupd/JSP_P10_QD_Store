<%@page import="pkg.goods.DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="dao" class="pkg.goods.DAO" />    
<%
List<DTO> list = dao.mtdSelect();
%>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap" class="listWrap">
	<h1>상품 목록</h1>
	<hr>
	
	<div class="btnArea">
		<button type="button" class="goodsReg">등록</button>
	</div>
	
	<main id="listMain" class="dFlex">
	
	<% for (int i=0; i<list.size(); i++) { 
		DTO dto = list.get(i);
	%>
		<div class="goodsItem">
			<input type="hidden" value="<%=dto.getNumber() %>">
			<input type="hidden" value="<%=dto.getUpFName() %>">
			<div class="imgArea">
				<img src="/fileStorage/<%=dto.getUpFName() %>" 
				width="220px" alt="이미지">
			</div>
			<div class="infoArea">
				<div class="topInfo dFlex">
					<span><%=dto.getGoodsName() %></span>
					<span class="delIcon">&times;</span>
				</div>
				<p class="price"><%=dto.getPrice() %></p>
			</div>
		</div>
	<% } %>
	
	</main>
	<!-- main#listMain -->
	
	<div class="btnArea">
		<button type="button" class="goodsReg">등록</button>
	</div>
		
	</div>
	<!-- div#wrap -->
	<script src="/script/jquery-3.7.1.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    