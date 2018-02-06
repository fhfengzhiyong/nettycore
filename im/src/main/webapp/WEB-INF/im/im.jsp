<!DOCTYPE html>
<html>
<head>
    <title>Testing websockets</title>
</head>
<body>
<div>
    <input type="submit" value="Start" onclick="start()"/>
</div>
<div id="notification"></div>
<script type="text/javascript">
    var webSocket =
        new WebSocket('ws://localhost:8085/im/Websocket');
    webSocket.onerror = function (event) {
        onError(event)
    };

    webSocket.onopen = function (event) {
        onOpen(event)
    };

    webSocket.onmessage = function (event) {
        onMessage(event)
    };

    function onMessage(event) {
        var data = JSON.parse(event.data);
        document.getElementById('notification').innerHTML
            += '<br />' + data.message_context;
    }

    function onOpen(event) {
        document.getElementById('notification').innerHTML = 'Connection established';

        // webSocket.send("{'type':'auth','message_context':'ste','from_user':'0be697f0-fbd9-446b-a4ea-ddcedc73ae90','to_user':''}");
    }

    function onError(event) {
        alert(event.data);
    }

    function start() {
        webSocket.send('hello');
        return false;
    }
</script>
</body>
</html>