<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery, Ajax and Servlet/JSP integration example</title>

<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script>
<!-- script src="/js/app-ajax.js" type="text/javascript"-->

$(document).ready(function() {
    $('#userName').click(function(event) {
            var name = $('#userName').val();
            $.get('AjaxSecondServlet' , function(responseText) {
                console.log(responseText);
                   var result= $('#ajaxGetUserServletResponse');//.text(responseText);
                   $.each(responseText,function(key,value){
                	   result.append(" key : "+key+" , value : "+value+"</br>");		
                   });
            });
    });
});

/*
 $(document).ready(function(){
   var posting = $.post( "jsp/html/ControlFlow.jsp" );
	   posting.done(function( data ) { 
		   $('#fbitwelContainer').html(data);
	  });

    
 });  
 */
 
 
</script>
</head>
<body>

	<form action="ajax">
		Enter Your Name: <input type="submit" id="userName" value="ckick"/>
	</form>
	<br>
	<br>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>

</body>
</html>