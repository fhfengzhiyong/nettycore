<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>aa</title>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }

        html, body {
            height: 100%;
        }

        body {
            font-size: 14px;
            line-height: 24px;
        }

        #tip {
            position: absolute;
            right: 0px;
            bottom: 0px;
            height: 0px;
            width: 180px;
            border: 1px solid #CCCCCC;
            background-color: #eeeeee;
            padding: 1px;
            overflow: hidden;
            display: none;
            font-size: 12px;
            z-index: 10;
        }

        #tip p {
            padding: 6px;
        }

        #tip h1 {
            font-size: 14px;
            height: 25px;
            line-height: 25px;
            background-color: #0066CC;
            color: #FFFFFF;
            padding: 0px 3px 0px 3px;
            filter: Alpha(Opacity=100);
        }

        #tip h1 a, #detail h1 a {
            float: right;
            text-decoration: none;
            color: #FFFFFF;
        }
    </style>
    <script type="text/javascript">
        window.onload = function () {
            var divTip = document.createElement("div");
            divTip.id = "tip";
            divTip.innerHTML = "<h1><a href='javascript:void(0)' onclick='start()'>关闭</a>title</h1><p><a href='javascript:void(0)' onclick='showwin()'>content</a></p>";
            divTip.style.height = '0px';
            divTip.style.bottom = '0px';
            divTip.style.position = 'fixed';
            document.body.appendChild(divTip);
        }
        var handle;
        function start(count) {
            var obj = document.getElementById("tip");
            if (parseInt(obj.style.height) == 0) {
                obj.style.display = "block";
                handle = setInterval("changeH('up')", 20);
            }
            else {
                handle = setInterval("changeH('down')", 20)
            }
        }
        function changeH(str) {
            var obj = document.all ? document.all["tip"] : document.getElementById("tip"); //docuemnt.all ??????
            if (str == "up") {
                if (parseInt(obj.style.height) > 100)
                    clearInterval(handle);
                else
                    obj.style.height = (parseInt(obj.style.height) + 8).toString() + "px";
            }
            if (str == "down") {
                if (parseInt(obj.style.height) < 8) {
                    clearInterval(handle);
                    obj.style.display = "none";
                }
                else
                    obj.style.height = (parseInt(obj.style.height) - 8).toString() + "px";
            }
        }
        function showwin() {
            //document.getElementsByTagName("html")[0].style.overflow = "hidden";
            start();
        }
    </script>
</head>
<body>
<a href="###" onclick="start()">click</a>
</body>
</html>