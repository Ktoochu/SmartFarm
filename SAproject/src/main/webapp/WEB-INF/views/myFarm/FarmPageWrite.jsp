<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/FarmPageCss.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� ������ �ۼ�</title>
</head>

<body>
	<div class="container">

		<div class="header">
			<center>
				<h1>��� ������ �ۼ�</h1>
			</center>
		</div>

		<form action="insert" method="post" enctype="multipart/form-data" accept-charset="utf-8">
			<div class="content">
				<br/> <label>�󰡸�: ${farm.getFarmName()}</label> <br/> <br/>
				<label>����</label>
				<input type="file" name="filename" size=20> <br/> <br/>
				<label>�ڸ�Ʈ</label>
				<input type="text" name="comment" /> <br/> <br/>

				<button type="submit">�ۼ�</button>
				<center>
					<a href="FarmPageMain">���ư���</a>
				</center>
			</div>
		</form>
		
	</div>
</body>
</html>


