package com.straw.nettycore.json;

import java.util.List;

/**
 * @author fengzy
 * @date 4/18/2018
 */
public class Page<T> {
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
