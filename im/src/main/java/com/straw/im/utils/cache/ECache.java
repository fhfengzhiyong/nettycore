package com.straw.im.utils.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * @author fengzy
 * @date 2/5/2018
 */
public class ECache {
    public static final String CACHE_NAME = "im";

    static {
        CacheManager.getInstance().addCache(CACHE_NAME);
    }

    public static Cache getCache() {
        Cache cache = CacheManager.getInstance().getCache(CACHE_NAME);
        return cache;
    }
}
