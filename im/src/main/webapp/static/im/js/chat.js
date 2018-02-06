var html;
var static = orgin + "/static/im/";

function load_url() {
    $(".chat_inter").click(function () {
        $('#chat_content').modal();
        count = 11;
    });
    open_tcp();
}
var count;
var isshow = false;
function blink_(selector) {
    count = 0;
    if (!isshow) {
        isshow = true;
        blink(selector);
    }
}
function blink(selector) {
    $(selector).fadeOut('slow', function () {
        $(this).fadeIn('slow', function () {
            count++;
            count < 10 ? blink(this) : isshow = false;
        });
    });
}

var static = "http://" + orgin + "/static/im/";
var userlist = new Array();

//var $("#frame3d").contents().find("#chat_content");
function e() {

    var type = "text";
    if ($('#notify_choose').prop('checked')) {
        type = "m_notify";
    }
    var e = new Date, f = "";
    f += e.getFullYear() + "-", f += e.getMonth() + 1 + "-", f += e.getDate() + "  ", f += e.getHours() + ":", f += e.getMinutes() + ":", f += e.getSeconds();
    var g = $("#textarea").val();
    var to_user = "";
    $(".talkTo li[id^='li-']").each(function () {
        to_user += this.id.substr(3);
    });
    if (g != '' && g.trim().length > 0) {
        var message = {
            "type": type,
            "message_context": g,
            "from_user": userId,
            "to_user": to_user
        };
        webSocket.send(JSON.stringify(message));
    }
    $("#textarea").val("");
}
$(document).ready(function () {
    setTimeout("load_url()", 1);

    var a = 3, b = static + "img/head/2024.jpg", c = static + "img/head/2015.jpg", d = "\u738b\u65ed";
    document.onkeydown = function (a) {
        if (webSocket.readyState != 1) {
            notification("未连接！");
            $("#chat_inter").addClass("chat_inter").removeClass("chat_inter_online");
        }
        var b = document.all ? window.event : a;
        return 13 == b.keyCode ? (e(), !1) : key_();
    }, $.fn.setCursorPosition = function (a) {
        return 0 == this.lengh ? this : $(this).setSelection(a, a)
    }, $.fn.setSelection = function (a, b) {
        if (0 == this.lengh)return this;
        if (input = this[0], input.createTextRange) {
            var c = input.createTextRange();
            c.collapse(!0), c.moveEnd("character", b), c.moveStart("character", a), c.select()
        } else input.setSelectionRange && (input.focus(), input.setSelectionRange(a, b));
        return this
    }, $.fn.focusEnd = function () {
        this.setCursorPosition(this.val().length)
    }
}), function (a) {
    a.extend({
        blinkTitle: {
            show: function () {
                var a = 0, b = document.title;
                if (-1 == document.title.indexOf("\u3010"))var c = setInterval(function () {
                    a++, 3 == a && (a = 1), 1 == a && (document.title = "\u3010\u3000\u3000\u3000\u3011" + b), 2 == a && (document.title = "\u3010\u65b0\u6d88\u606f\u3011" + b)
                }, 500);
                return [c, b]
            }, clear: function (a) {
                a && (clearInterval(a[0]), document.title = a[1])
            }
        }
    })
}(jQuery);
var webSocket;
function open_tcp() {
    webSocket = new WebSocket('ws://' + orgin + '/websocket');
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
        //console.info("接受到消息===" + event.data);
        var data = JSON.parse(event.data);
        dealEvent(data);
    }

    function onOpen(event) {
        notification("链接成功");
        //发送身份说明
        webSocket.send("{'type':'auth','message_context':'','from_user':'" + userId + "','to_user':''}");
        $("#chat_inter").addClass("chat_inter_online").removeClass("chat_inter");
    }

    function onError(event) {
        //alert("通信已断开！");
        notification("通信已断开！");
        $("#chat_inter").addClass("chat_inter").removeClass("chat_inter_online");
    }
}
var tmid;
//处理响应消息
function dealEvent(data) {

    if (data.type == "user_login") {
        //var user= JSON.parse(data.message_context);
        // userlist[userlist.length]=user;
        // var userl= "<li id='"+user.id+"'><label class='online'></label><a href='javascript:;'><img class='img_a'/></a><a href='javascript:;' class='chat03_name'>"+user.nickName+"</a></li>";
        // $("#user_list").append(userl);
        //获取好友
        webSocket.send("{'type':'online_user','message_context':'','from_user':'','to_user':''}");
    } else if (data.type == "user_list") {
        $("#user_list").text("");
        userlist = JSON.parse(data.message_context);
        var user_list = "";
        for (var i = 0; i < userlist.length; i++) {
            var name = userlist[i].nickName;
            //<label class='online'></label>
            user_list += "<li id='" + userlist[i].id + "'><div href='javascript:;'><div class='img_a'>" + name.substring(name.length - 1, name.length) + "</div><a href='javascript:' onclick=single_chat('" + userlist[i].id + "','" + name + "'); onclick='' class='chat03_name'>" + name + " </a>";
            if (authRole) {
                user_list += "<a href='javascript:' onclick=offline('" + userlist[i].id + "');  class='chat04_name'>X</a>";
            }
            user_list += " </li>";
        }
        $("#user_list").append(user_list);
    } else if (data.type == "text") {
        var mess = messageBuild(data);
        whowMeswsage(mess);
    } else if (data.type == "user_logout") {
        var id = data.message_context;
        for (var i = 0; i < userlist.length; i++) {
            if (userlist[i].id == id) {
                userlist[i] = '';
            }
        }
        $("#" + id).remove();
    } else if (data.type == "m_user_logout") {
        alert("您被强制退出系统，请稍后登录。");
        frame3d.window.exitSystem();
        webSocket.close();
    } else if (data.type == "m_notify") {
        $("#notify").fadeIn("slow");
        $("#notify_contnt").html(data.message_context);
        window.clearTimeout(tmid);
        tmid = window.setTimeout(function () {
            $("#notify").fadeOut("slow");
        }, 60000);
        c = 60;
        clearTimeout(t);
        timedCount();
    } else if (data.type = "invalid") {
        webSocket = new WebSocket('ws://' + orgin + '/websocket');
    }
}
var c, t;
function timedCount() {
    c > -1 ? ($('#timeout').html(c + "s"), c = c - 1, t = setTimeout("timedCount()", 1000)) : clearTimeout(t);
}
function h(g) {
    -1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='" + static + "img/").replace("#*", ".gif'/>"), h(g));
    return g;
};
//构建消息
function messageBuild(data) {
    var cont = data.message_context;
    cont = h(cont);
    var con = "<div class='message clearfix'>" + "<div class='wrap-text'>";
    if (data.from_user == userId) {
        con += "<h5 class='clearfix'>" + data.from_user_nick + "</h5>";
    } else {
        con += "<h6 class='clearfix'>" + data.from_user_nick + "</h6>";
    }
    con += "<div>" + cont + "</div>" +
        "</div>" + "<div class='wrap-ri'>" + "<div clsss='clearfix'><span>" + data.message_date + "</span></div>" + "</div>" +
        "<div style='clear:both;'></div>" + "</div>";
    return con;
}
//展示消息
function whowMeswsage(data) {
    ($(".mes").append(data), $(".chat01_content").scrollTop($(".mes").height()), $("#textarea").val(""), blink_('#chat_inter'));
}

//消息窗口
function notification(text) {
    document.getElementById('notification').innerHTML = text;
}
//处理在线用户
//注册快捷键
function key_() {
    var a = window.event.keyCode;
    //ctrl+q
    if ((a == 77) && (event.ctrlKey)) {
        $('#chat_content').modal();
    }
    if ((a == 81) && (event.ctrlKey)) {
        $('#chat_content').modal("hide");
    }
}

function offline(toUserId) {
    webSocket.send("{'type':'m_offline','message_context':'','from_user':'" + userId + "','to_user':'" + toUserId + "'}");
}
function single_chat(uid, uname) {
    if ($("#li-" + uid).length == 0) {
        $(".talkTo").append("<li title='点击取消' id='li-" + uid + "' onclick=cancel('li-" + uid + "')><a>" + uname + "</a></li>");
    } else {
        cancel("li-" + uid);
    }
}
function cancel(liid) {
    $("#" + liid).remove();
}

