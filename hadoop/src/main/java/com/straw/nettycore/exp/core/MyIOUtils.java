package com.straw.nettycore.exp.core;

import com.google.common.base.Preconditions;
import org.apache.hadoop.fs.FSDataInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author fengzy
 * @date 1/10/2018
 */
public class MyIOUtils {

    public static String toString(FSDataInputStream inputStream, String charset) throws IOException {
        Preconditions.checkArgument(inputStream!=null,"inputStream不能为空");
        if (charset == null&& "".equals(charset)){
            charset = "utf-8";
        }
        ByteArrayOutputStream baos   =   new   ByteArrayOutputStream();
        int i = 0;
        while((i=inputStream.read())!=-1){
            baos.write(i);
        }
        return baos.toString(charset);
    }


}
