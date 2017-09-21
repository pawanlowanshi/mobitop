<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>SO question 4112686</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script>
       /* $(document).ready(function() {                       
            $('#somebutton').click(function() {               
                $.get('CheckAjaxCall', function(responseText) { 
                    $('#somediv').text(responseText);        
                });
            });
        });


        $("#somebutton").click(function(){
         $.ajax({
            url:'CheckAjaxCall',
            data:{name:'abc'},
            type:'get',
            cache:false,
            success:function(data){
               alert(data);
               $('#somediv').text(responseText); 
            },
            error:function(){
              alert('error');
            }
         }
    );
}
);*/

$(document).ready(function() {
    $(this).click(function() {
        servletCall();
    });

});
function servletCall() {
    $.post(
        "CheckAjaxCall", 
        {name : "pawan"}, //meaasge you want to send
        function(result) {
        $('#somediv').html('Here is your result : <strong>' + result + '</strong>'); //message you want to show
    });
};

    </script>
</head>
<body>

    <button id="somebutton">press here</button>
    <button id="somebutton1">press here</button>
    <div id="somediv"> </div>
</body>
</html>