<html>
    <head>
    </head>
    <body>
        <table>
            <tr><td><input type="text" id="val1"/></td></tr>
            <tr><td><input type="text" id="val2"/></td></tr>
            <tr><td><input type="button" id="btn" onclick="calculate()" value="Calculate"/></td></tr>
            <tr><td><input type="text"  id="res"/></td></tr> 
        </table>   
        
    </body>

</html>
<script>  
   function calculate()
   {
var val1 = document.getElementById("val1").value;
var val2 = document.getElementById("val2").value;
document.getElementById("res").value = parseInt(val1) + parseInt(val2); 

   }   
 </script>