package com.straw.nettycore.test.cli2netty.from;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author fengzy
 * @date 2/24/2018
 */
public interface SendService<V> {
    /**
     * 发送数据
     *
     * @param v 数据类型
     */
    void send(V v) throws URISyntaxException, IOException;
}
