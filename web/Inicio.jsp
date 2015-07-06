<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>	
        <link type="text/css" rel="stylesheet" href="css/principal.css"/>


        <link rel='stylesheet' id='style-css'  href='Slider/diapo.css' type='text/css' media='all'> 
        <script type='text/javascript' src='Slider/scripts/jquery.min.js'></script>
        <!--[if !IE]><!--><script type='text/javascript' src='Slider/scripts/jquery.mobile-1.0rc2.customized.min.js'></script><!--<![endif]-->
        <script type='text/javascript' src='Slider/scripts/jquery.easing.1.3.js'></script> 
        <script type='text/javascript' src='Slider/scripts/jquery.hoverIntent.minified.js'></script> 
        <script type='text/javascript' src='Slider/scripts/diapo.js'></script> 

    </head>
    <script>
        $(function() {
            $('.pix_diapo').diapo();
        });

    </script>


</head> 
<body>  
<center>
    <div id="banner">
        <section> 

            <div style="overflow:hidden; width:98%; margin: 100px auto; padding:0 20px;"> 
                <div class="pix_diapo">

                    <div data-thumb="Slider/images/thumbs/Slinder01.png">
                        <img src="Slider/images/slides/Slinder1.png">
                    </div>

                    <div data-thumb="Slider/images/thumbs/Slinder02.png">
                        <img src="Slider/images/slides/Slinder2.png">  
                    </div>

                    <div data-thumb="Slider/images/thumbs/Estantes.jpg" data-time="7000">
                        <img src="Slider/images/slides/Slinder1.png">
                    </div>


                </div><!-- #pix_diapo -->

            </div>


        </section> 
    </div>
</center>

<div id="Cata">
    <div class="menu" id="menu" >
        <ul id="boton">
            <li id="letra"> 
            <center> <img src="ImaCatalogo/1.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p>  </center>
            </li> 
            <li id="letra">  
            <center> <img src="ImaCatalogo/2.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p>  </center>
            </li> 
            <li id="letra">   
            <center> <img src="ImaCatalogo/3.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p> </center>
            </li>
            <li id="letra">   
            <center> <img src="ImaCatalogo/4.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p> </center>
            </li>
            <li id="letra">   
            <center> <img src="ImaCatalogo/5.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p> </center>
            </li>
            <li id="letra">   
            <center> <img src="ImaCatalogo/6.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p>  </center>
            </li>
            <li id="letra">   
            <center> <img src="ImaCatalogo/7.jpg" width="80" height="80"/><br>
                <p id="txtcat"> código #055n2 </p>  </center>
            </li>
        </ul>
    </div>
</div>


<style>
    body{
     //   background: #B0FFF0;
    }
    section {
        display: block;
        overflow: hidden;
        position: relative;
    }
    .button {
        background: #014464;
        background: -moz-linear-gradient(top, #0D658E, #0C577A 50%, #014D71 51%, #003E5C);
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0, #0E658E), color-stop(.5, #0C577A), color-stop(.5, #014D71), to(#003E5C)); 
        border: 1px solid #368DBE;
        border-top: 1px solid #c3d6df;
        -moz-border-radius: 4px;
        -webkit-border-radius: 4px;
        border-radius: 4px;
        -moz-box-shadow: 0 1px 3px black;
        -webkit-box-shadow: 0 1px 3px black;
        box-shadow: 0 1px 3px black;
        color: white;
        display: block;
        font-size: 12px;
        font-weight: bold;
        height: 30px;
        line-height: 30px;
        padding: 5px 20px;
        text-align: center;
        text-decoration: none;
        text-shadow: 1px 1px 1px black;
        text-transform: uppercase;
        width: auto;
    }
    .button2 {
        background: #d9ae00;
        background: -moz-linear-gradient(top, #b28b06, #9c7705 50%, #9c7705 51%, #5c4100);
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0, #b28b06), color-stop(.5, #9c7705), color-stop(.5, #9c7705), to(#5c4100)); 
        border: 1px solid #c7a60c;
        border-top: 1px solid #e5d51f;
    }
    .button3 {
        background: #ffd838;
        background: -moz-linear-gradient(top, #edbf21, #c89b0f 50%, #9c7705 51%, #906706);
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0, #edbf21), color-stop(.5, #c89b0f), color-stop(.5, #c89b0f), to(#906706)); 
        border: 1px solid #c7a60c;
        border-top: 1px solid #e5d51f;
    }
    .price_table {
        float: right;
        font-size: 12px;
        margin: 10px auto 0;
        padding: 20px 0;
        position: relative;
        width: 570px;
    }
    .price_table .price_column.highlighted {
        background: #ffd838;
        margin: -5px!important;
        padding: 10px;
        z-index: 2;
    }
    .price_table .price_column {
        display: block;
        margin: 5px;
        float: left;
        position: absolute;
        width: 180px;
        z-index: 1;
    }
    .price_table .price_column > div {
        background: #eeeeee;
    }
    .price_table .price_column > div > div {
        padding: 10px 15px;
        border-bottom: 1px solid #cccccc;
        border-top: 1px solid #f6f6f6;
    }
    .price_table .price_column > div > p {
        padding: 10px 15px;
        border-bottom: 1px solid #cccccc;
        border-top: 1px solid #f6f6f6;
    }
    .price_table .price_column > div > ul {
        padding: 10px 15px;
        border-bottom: 1px solid #cccccc;
        border-top: 1px solid #f6f6f6;
    }
    .price_table .price_title {
        background-color: #333333;
        border-top: 0!important;
        color: #ffffff;
        font-size: 14px;
    }
    .price_table .highlighted .price_title {
        font-size: 16px;
    }
    .price_table .price_price {
        font-size: 36px;
        line-height: 40px;
    }
    .price_table .highlighted  .price_price {
        font-size: 40px;
        line-height: 44px;
    }
    .price_table .price_explanation {
        font-size: 10px;
        line-height: 13px;
        text-transform: uppercase;
    }
    .price_table .cusButton {
        background-color: #333333;
        display: block;
        text-align: center;
    }
    .price_table li {
        padding: 5px 0;
    }
    .price_table div.pix_check {
        background: url(InicioImage/images/demo/list-check-green.png) no-repeat 15px center;
        padding-left: 38px!important;
    }
    .price_table div.pix_error {
        background: url(InicioImage/images/demo/list-error.png) no-repeat 15px center;
        padding-left: 38px!important;
    }


    body {
        margin-top: -7%;
        font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        font-size: 12px;
        line-height: 20px;
    } 
    #Cata{
        margin-top: -11%;
        margin-bottom: 3%;
    }
    #menu{
        margin-bottom: 3%;

    }
    #menu  li  {
        display: inline;
    }

    #letra{
        position: relative;
        width: 10%;
        height: 15%;
        margin-top: 40px;
        font-size: 125%;
        text-decoration: none;
        float: left;
        padding: 10px;
        margin-left: 2%;
        background-color:  #00a383;
        color: black;
        font-family: Arial;
        font-size: 14px;
        border-radius: 10px;
    }
    #txtcat{
        font-family: Arial;
        font-size: 110%;
    }


</style>
</body>
</html>