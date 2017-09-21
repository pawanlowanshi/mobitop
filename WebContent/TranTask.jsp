<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
 <script>
 $(document).ready(function(){
	 $.ajax({ url: "TranDetailsAction",
	         context: document.body,
	         success: function(){
	            alert("done");
	         }});
	 });
 </script>
</head>
<body>
<form method="post" action="https://mdepayments.epdq.co.uk/ncol/test/orderstandard.asp" id=form1 name=form1>
 
<input type="hidden" name="PSPID" value="epdq1060898">
<input type="hidden" name="ORDERID" value="INV-0001">
<input type="hidden" name="AMOUNT" value="1.00">
<input type="hidden" name="CURRENCY" value="GBP">
<input type="hidden" name="LANGUAGE" value="en-gb">
<input type="hidden" name="CN" value="harish">
 
<input type="hidden" name="SHASIGN" value="A17E918AE294AF8A72A083FE2F1383C3E7A3EE34">
 
<input type="submit" value="" id="submit2" name="submit2">
</form>
</body>
</html>
