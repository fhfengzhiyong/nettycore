package com.straw.im.utils.cache;

import com.straw.im.websocket.core.AdminUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengzy
 * @date 2/7/2018
 */
public class NapCache {
    static Map<String, AdminUser> map = null;

    public static NapCache Instance() {
        NapCache napCache = new NapCache();
        map = new HashMap<String, AdminUser>();
        return napCache;
    }

    public static boolean putValue(String key, AdminUser user) {
        map.put(key, user);
        return true;
    }

    public static AdminUser getValue(String key) {
        return map.get(key);
    }
}
