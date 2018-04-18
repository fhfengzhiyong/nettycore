package com.straw.nettycore.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengzy
 * @date 4/17/2018
 */
public class FastJsonTest {
    @Test
    public void t1() {
        TaobaoMaterial material = new TaobaoMaterial();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "this is a name");

        material.setBranchCid(1L);
        material.setTitle("11111");
        material.setClickUrl("5555555555");

        map.put("data", material);
        Page page = new Page();
        ArrayList arrayList = new ArrayList();
        arrayList.add(material);
        page.setDatas(arrayList);
        System.out.println(JSON.toJSON(page));
    }
}
