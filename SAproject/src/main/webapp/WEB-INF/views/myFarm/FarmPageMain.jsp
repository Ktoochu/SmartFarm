<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<!-- ?after => �ٲ� ��Ÿ�� ��Ʈ ���� �ȵż� �߰� -->
<link href="assets/css/FarmPageCss.css?after" rel="stylesheet" type="text/css">
<meta charset="EUC-KR">

<title>��� ������</title>
</head>
<body>

<div class="container" align="center">

	<div class="header">
		<!-- ${farm.getFarmName()}�� �󰡸�����, ���߿� �α���/ȸ������ ����� �Ϸ�Ǹ� ���ǿ� ID �� ������ ����Ѵ�. -->
		<h1> ${farm.getFarmName()} ���� ������ </h1>
	</div>
	
	<div class="content">
		<c:set var="start" value="0" />
		<c:set var="end" value="2" />
		<c:set var="len" value="${fn:length(gallerys)}" />

		<div id="galImgs">
			<a style="cursor:pointer">��</a>
			<!-- �̹����� ���� �� -->
			<c:if test="${empty gallerys}">
				<div><img src="assets/images/Tulips.jpg">
				<p><c:out value="�Է��� ������ �����ϴ�."/></p></div>
			</c:if>
			<!-- �̹����� ���� �� 3���� ��� -->
			<c:forEach items="${gallerys}" var="gallery" varStatus="status" begin="${start}" end="${end}">
	                <div><img src="${gallery.getPhoto_path()}" class="galImg">
	                <p><c:out value="${gallery.getComment()}"/></p></div>  
	        </c:forEach>
            <a style="cursor:pointer">��</a>
		</div>
	    
		<table border="1" width="800">
			<tr>
				<th>��ȣ</th>
				<th>�ı� ����</th>
				<th>�ۼ���</th>
				<th>����</th>
				<th>��¥</th>
			</tr>
			
			<tr>
				<td>1</td>
				<td>����������������������������</td>
				<td>kim</td>
				<td>�ڡ١١١�</td>
				<td>2020.08.04</td>
			</tr>
			
			<tr>
				<td>2</td>
				<td>aaaa</td>
				<td>lee</td>
				<td>�ڡڡ١١�</td>
				<td>2020.08.04</td>
			</tr>
			
			<tr>
				<td>3</td>
				<td>bb</td>
				<td>park</td>
				<td>�ڡڡڡ١�</td>
				<td>2020.08.04</td>
			</tr>
			
			<tr>
				<td>4</td>
				<td>cccc</td>
				<td>hong</td>
				<td>�ڡڡڡڡ�</td>
				<td>2020.08.04</td>
			</tr>
			
			<tr>
				<td>5</td>
				<td>555555</td>
				<td>jung</td>
				<td>�ڡڡڡڡ�</td>
				<td>2020.08.04</td>
			</tr>
		</table>
		<a href="FarmPageReview">�ı��ۼ�</a>
	</div>
	  
	<div class="sidebar">
		<br>
		<p>${farm.getFarmName()} ���� ������</p><br>
		<p>������� : ${farm.getAvgStar()}</p><br>
		<p>��ŷ : ${farm.getRatings()}</p><br>
		<a href="FarmPageModify">������ �����ϱ�</a><br/>
		<a href="FarmPageWrite">���� �Է��ϱ�</a>
	</div>
</div> 
   
</body>
</html>