package com.straw.im.websocket.web;


import com.straw.im.websocket.core.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/6/29.
 */
@Controller
@RequestMapping("/onLineChat")
public class OnLineChartController {
    @RequestMapping("im")
    public String ImTest() {
        return "im/im";

    }

    @RequestMapping("chat")
    public String Chat(HttpServletRequest request) {
        AdminUser adminUser = new AdminUser();
        adminUser.setId("123");
        adminUser.setNickName("straw");
        if (adminUser != null) {
            request.setAttribute("userKey", adminUser.getId());
        }
        request.setAttribute("user", adminUser);
        return "/im/chat";
    }
}
