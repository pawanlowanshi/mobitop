<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function getDeviceDetails() {
		//alert("test");
		document.getElementById("demo").innerHTML = "All Device list is ...";
		var str = "";
		var deviceIds=new Array();
		<%
		 int deviceNum=0;
		 List<List<String>> innerList=new ArrayList<List<String>>();
		 List<Map<String, List<String>>> list=(List<Map<String, List<String>>>)session.getAttribute("deviceDetailsList");
			
			for (int i=0;i<list.size();i++){
			    deviceNum=i;
			    innerList.add(list.get(i).get(new ArrayList(list.get(i).keySet()).get(i)));
			    
		%>
		deviceIds[<%= i %>] = "<%= new ArrayList(list.get(i).keySet()).get(i)%>";		
		<%}%>
		alert(deviceIds);
		for ( var i = 0; i < deviceIds.length; i++) {
			str = str +"<button>" + deviceIds[i]+ "</button>"+ "<li onclick=subDetails("+i+")><font color='blue'><u>&nbspClick for Details</u></font><ul id=inner"+i+"></ul></li>";
		}
		document.getElementById("outer").innerHTML = str;
		
	}

	function subDetails(i) { 
		var str = "";
		var deviceAttr=["Model Name","Android Version","SDK Version"];
		var deviceIdsDetails = "<%= innerList.get(deviceNum)%>";
		var details=deviceIdsDetails.replace("[","").replace("]","").split(",");
		for ( var j = 0; j < details.length; j++) {
			
			str=str+"<li>"+deviceAttr[j]+":&nbsp;<font color='red'>" + details[j]+ "</li>";
		}
		document.getElementById("inner"+i).innerHTML = str;
	}

	function onServer(){
		WshShell = new ActiveXObject("Wscript.Shell"); //Create WScript Object
		   WshShell.run("D:/Appium/Appium.exe"); //here we can't provide c drive location because permission is required.
		
	}
</script>
</head>
<body>
	<h1>MobiTop</h1>
	<input type="submit" value="Device List" onclick="getDeviceDetails();">
	<form action='serverlink'>
	<p id="demo">Welcome to our page.</p>
	<ul id="outer"></ul>
	</form>
</body>
</html>