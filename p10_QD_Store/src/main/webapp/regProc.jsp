<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="pkg.goods.DTO" />
<jsp:setProperty name="dto" property="*" />

<jsp:useBean id="fuo" class="pkg.goods.FUO" />
<%
fuo.mtdUpload(request, dto);
%>

<jsp:useBean id="dao" class="pkg.goods.DAO" />
<%
boolean chk = dao.mtdInsert(dto);
%>
<script>
<% if (chk) { %>
	alert("등록되었습니다!");
	location.href="list.jsp";
<% } else { %>	
	alert("등록실패");
	history.back();
<% } %>
</script>


