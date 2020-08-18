<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link href="assets/css/FarmPageCss.css" rel="stylesheet" type="text/css">
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
		<img src="${farm.getPhoto()}" width="400">
		<p>${farm.getComment()}</p>
		
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