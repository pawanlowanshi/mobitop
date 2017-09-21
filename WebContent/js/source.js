function getDeviceDetails() {
		document.getElementById("demo").innerHTML = "All Device list is ...";
		var str = "";
		var deviceIds = [ "123povd", "321jhgf", "678ud", "121bghg", "32ghvj" ];
		var deviceIdsDetails =new Array( "micromax", "5.0.1", "21" );
		for ( var i = 0; i < deviceIds.length; i++) {
			str = str + "<li onclick=subDetails("+i+",'"+deviceIdsDetails+"')><a href='"+deviceIds[i]+"'>" + deviceIds[i]+ "</a><u>Details</u><ul id='inner"+i+"'></ul></li>";
		}
		document.getElementById("outer").innerHTML = str;
	}

	function subDetails(i,deviceIdsDetails) {

		var str = "";
	//	var deviceIdsDetails = [ "micromax", "5.0.1", "21" ];
		for ( var j = 0; j < deviceIdsDetails.length; j++) {
			str=str+"<li>" + deviceIdsDetails[j]+ "</li>";
		}
		document.getElementById("inner"+i).innerHTML = str;
	}