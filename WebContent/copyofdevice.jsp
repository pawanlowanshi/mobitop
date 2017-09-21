<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function getDeviceDetails() {
		document.getElementById("demo").innerHTML = "All Device list is ...";
		var str = "";
		<%
		 List<Map<String, List<String>>> list=(List<Map<String, List<String>>>)session.getAttribute("deviceDetailsList");
			for (Map<String, List<String>> map:list){
		%>
		var deviceIds = [ "123povd", "321jhgf", "678ud", "121bghg", "32ghvj" ];
		for ( var i = 0; i < <%list.size();%>; i++) {
			str = str + "<li onclick='subDetails("+i+","+<%map.get(map.entrySet().iterator().next());%>+")'><u>" <%map.entrySet().iterator().next();%> "</u><ul id='inner"+i+"'></ul></li>";
		}
		document.getElementById("outer").innerHTML = str;
		<%}%>
	}

	function subDetails(i,mapValue) {
		//alert(" gsd");
		var str = "";
		
		//var deviceIdsDetails = [ "micromax", "5.0.1", "21" ];
		for ( var j = 0; j < mapValue.length; j++) {
			
			str=str+"<li>" + mapValue[j]+ "</li>";
		}
		document.getElementById("inner"+i).innerHTML = str;
	}
</script>
<body>
 <form action="deviceData">
	<h1>MobiTop</h1>
	<input type="submit" value="Device List" onclick="getDeviceDetails()">
	<p id="demo">Welcome to our page.</p>
	<ul id="outer"></ul>
	</form>
</body>
</html>