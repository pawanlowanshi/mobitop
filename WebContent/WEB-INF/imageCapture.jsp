<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>

//for getting coardinate..
$(document).ready(function() {
  $('img').click(function(e) {
    var offset = $(this).offset();
    var i=e.pageX - offset.left;
    var j=e.pageY - offset.top;
    document.getElementById("id").innerHTML="Left position: " + j +"&nbsp;&nbsp;"+ " Top position: " + i;
    //docoment.getElementById("bound").innerHTML= "["+j+","+i+"]" ;
  });
});

//for displaying image..
$(function () {
    $(":file").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
        }
    });
});

//for target on loaded image..
function imageIsLoaded(e) {
    $('#myImg').attr('src', e.target.result);
};

function placeElement(){
	var str="";
	var myElement="textbox";
	var val="808";
	var arr=[939,68,585,86];
	if("textbox"==myElement){
	  str=str + "<input type='text' id='txt' placeholder='enter' STYLE='position:absolute; top:"+val+"px; left:76px; width:585px; height:86px';/>";
	  str=str+"<button id='btn' STYLE='position:absolute; top:"+(arr[0]+8)+"px; left:"+(arr[1]+8)+"px; width:"+arr[2]+"px; height:"+arr[3]+"px'; background-color='#f44336'>FIND CAR</button>" ;
	}else if("button"==myElement){
	   str=str+"<button id='btn' STYLE='position:absolute; top:"+(arr[0]+8)+"px; left:"+(arr[1]+8)+"px; width:"+arr[2]+"px; height:"+arr[3]+"px'; background-color='#f44336'>FIND CAR</button>" ;
	}else if("checkbox"==myElement){
	   str=str+"<input type='checkbox' id='chkbx' STYLE='position:absolute; top:808px; left:76px; width:585px; height:86px';/>";
	}else if("textarea"==myElement){
		str=str+"<textarea rows='1' cols='10' id='txtarea' STYLE='position:absolute; top:808px; left:76px; width:585px; height:86px';/>";
	}else if("radioButton"==myElement){
		str=str+"<input type='radio' id='rbtn' STYLE='position:absolute; top:808px; left:76px; width:585px; height:86px';/>";
	}
	document.getElementById("div").innerHTML=str;
	alert("alert");
	}
</script>
</head>
<body>

<!-- p id="bound">Here will get coordinates values.</p-->
<!-- form action="imgProcess"-->
<div id="div"></div>
<!-- /form-->
<div>
<img id="myImg" src="" onload="placeElement()" usemap="#planetmap"/>
</div>
<input type='file' />
<p id="id">Here will get coordinates values.</p>

<!--  input type='file' />
<p id="id">Here will get coordinates values.</p>
<!-- p id="bound">Here will get coordinates values.</p>
<img id="myImg" src=""/-->



</body>
</html>