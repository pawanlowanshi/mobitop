<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<script type="text/javascript">
	function getDeviceDetails() {
		document.getElementById("demo").innerHTML = "All Device list is ...";
		var str = "";
		var deviceIds = [ "123povd", "321jhgf", "678ud", "121bghg", "32ghvj" ];
		var deviceIdsDetails = ["micromax", "5.0.1", "21"];
		for ( var i = 0; i < deviceIds.length; i++) {
			str = str +"<button>" + deviceIds[i]+ "</button>"+"&nbsp;<li onclick=subDetails("+i+",'"+deviceIdsDetails+"')><font color='blue'><u>&nbspClick for Details :-</u></font><ul id=inner"+i+"></ul></li><br/>";
		}
		document.getElementById("outer").innerHTML = str;
	}
	
	function test(){
		var WshShell;
			WshShell = new ActiveXObject("Wscript.Shell"); //Create WScript Object
			   WshShell.Exec("D:/Appium/Appium.exe");
	}
	
	function subDetails(i,deviceIdsDetails) {
		var str = "";
		var deviceAttr=["Model Name","Android Version","SDK Version"];
		var details=deviceIdsDetails.split(",");
		for ( var j = 0; j < details.length; j++) {
			str=str+"<li>"+deviceAttr[j]+":&nbsp;<font color='red'>" + details[j]+ "</font></li>";
		}
		document.getElementById("inner"+i).innerHTML = str;
	}
	
</script>
</head>
<body>

	<h1>MobiTop</h1>
	<input type="submit" value="Device List" onclick="getDeviceDetails()">
	<form action='serverlink'>
	<p id="demo">Welcome to our page.</p>
	<ul id="outer"></ul>
	</form>
</body>
</html>