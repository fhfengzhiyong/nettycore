package com.straw.nettycore.guava;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @author fengzy
 * @date 10/16/2017
 */
public class GuavaString {
    @Test
    public void t1(){
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
        System.out.println(possible.orNull());

    }


}
