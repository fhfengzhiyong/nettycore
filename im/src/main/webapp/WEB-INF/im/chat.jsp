<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <title>chat</title>
    <link rel="stylesheet" href="<c:url value='/static/im/css/chat_pic.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/static/im/css/chat.css'/>"/>
    <![endif]-->
</head>
<body class="keBody">
<!--效果html开始-->
<div class="chatBox">
    <div class="chatLeft">
        <div class="chat01">
            <div class="chat01_title">
                <span class="talk_tip ">点击用户私聊：</span>

                <ul class="talkTo">

                </ul>
                <a class="close_btn" href="javascript:;"></a>
            </div>
            <div class="chat01_content">
                <div class="message_box mes" style="display: block;">
                </div>

            </div>
        </div>
        <div class="chat02">
            <div class="chat02_title">
                <a class="chat02_title_btn ctb01" href="javascript:;"></a>
                <%--   <div class="chat02_title_btn ctb02"
                      href="###" title="选择文件">
                      <input type="file" id="file" class="file" />
                   </div>
                   <a class="chat02_title_btn ctb03" href="javascript:;" title="选择附件">--%>
                </a>
                <sec:authorize access="hasRole('e582a053-e2cf-406e-bb9d-5b7f5e9edbea')">
                    <label class="chat04_title_t" title="发送通知">
                        <input type="checkbox" value="1" id="notify_choose"/><span class="notify_choose_label"></span>
                    </label>
                </sec:authorize>


                <label class="chat02_title_t">
                    <a href="#" onclick="return $('.mes').html('')">清空记录</a></label>
                <div class="wl_faces_box">
                    <div class="wl_faces_content">
                        <div class="title">
                            <ul>
                                <li class="title_name">常用表情</li>
                                <li class="wl_faces_close"><span>&nbsp;</span></li>
                            </ul>
                        </div>
                        <div class="wl_faces_main">
                            <ul>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_01.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_02.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_03.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_04.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_05.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_06.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_07.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_08.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_09.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_10.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_11.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_12.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_13.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_14.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_15.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_16.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_17.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_18.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_19.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_20.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_21.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_22.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_23.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_24.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_25.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_26.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_27.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_28.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_29.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_30.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_31.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_32.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_33.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_34.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_35.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_36.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_37.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_38.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_39.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_40.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_41.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_42.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_43.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_44.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_45.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_46.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_47.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_48.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_49.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_50.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_51.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_52.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_53.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_54.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_55.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_56.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_57.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_58.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_59.gif"/></a></li>
                                <li><a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/static/im/img/emo_60.gif"/></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="wlf_icon">
                    </div>
                </div>
            </div>
            <div class="chat02_content">
                <textarea id="textarea"></textarea>
            </div>
            <div class="chat02_bar">
                <ul>
                    <li style="left: 20px; top: 10px; padding-left: 30px;"><span id="notification"></span></li>
                    <li style="right: 5px; top: 5px;">
                        <a onclick="e()" href="javascript:;">
                            <img src="${pageContext.request.contextPath}/static/im/img/send_btn.jpg"></a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="chatRight">
        <div class="chat03">
            <div class="chat03_title">
                <label class="chat03_title_t">
                    成员列表</label>
            </div>
            <div class="chat03_content">
                <ul id="user_list">

                </ul>
            </div>
        </div>
    </div>
    <div style="clear: both;">
    </div>
</div>
<!--效果html结束-->

</body>
</html>

<script src="<c:url value='/static/im/js/jquery-1.7.2.min.js'/>"></script>
<script type="application/javascript">
    $(document).ready(function () {
        $(".close_btn").click(function () {
            $('#chat_content', parent.document).modal('hide');
        });
        $(".close_btn").click(function () {
            $('#chat_content').modal('hide');
        }), $(".chat03_content li").mouseover(function () {
            $(this).addClass("hover").siblings().removeClass("hover")
        }).mouseout(function () {
            $(this).removeClass("hover").siblings().removeClass("hover");
        }), $(".chat03_content li").dblclick(function () {
            var b = $(this).index() + 1;
            a = b, c = "img/head/20" + (12 + a) + ".jpg", d = $(this).find(".chat03_name").text(), $(".chat01_content").scrollTop(0), $(this).addClass("choosed").siblings().removeClass("choosed"), $(".talkTo a").text($(this).children(".chat03_name").text()), $(".mes" + b).show().siblings().hide()
        }), $(".wl_faces_main img").click(function () {
            var a = $(this).attr("src");
            $("#textarea").val($("#textarea").val() + "*#" + a.substr(a.indexOf("img/") + 4, 6) + "#*"), $("#textarea").focusEnd(), $(".wl_faces_box").hide()
        });
        $(".ctb01").mouseover(function () {
            $(".wl_faces_box").show()
        }).mouseout(function () {
            $(".wl_faces_box").hide()
        }), $(".wl_faces_box").mouseover(function () {
            $(".wl_faces_box").show()
        }).mouseout(function () {
            $(".wl_faces_box").hide()
        }), $(".wl_faces_close").click(function () {
            $(".wl_faces_box").hide()
        })
    });
</script>

<script>
    var orgin, userId, authRole, sessionId;
    orgin = location.hostname + ":" + location.port + location.pathname.substr(0, location.pathname.substr(1, location.pathname.length).indexOf("/") + 1);
    authRole = true;
    sessionId = '<%= session.getId()%>';
</script>
<script src="<c:url value='/static/im/js/chat.js'/>"></script>