package com.straw.nettycore.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengzy on 7/26/2017.
 */
public class TestSubscribeReqProto {
    //所谓的编码就是转化为二进制数组
    private static byte[] encode(SubscribeReqProto.SubscribeReq req){
        return req.toByteArray();
    }
    //解码就是从二进制转化为有一定规律的字符串
    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }
    private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("straw");
        builder.setPreductName("Netty book");
        List<String> address = new ArrayList<String>();
        address.add("BeiJIng TianAnMen");
        address.add("TaiYuan XiaoDianQu");
        builder.setAddress("TaiYuan XiaoDianQu");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode: " + req.toString());
        SubscribeReqProto.SubscribeReq req1 = decode(encode(req));
        System.out.println("After decode : "+ req.toString());
        System.out.println("Assert equal : --> " + req1.equals(req));
    }




}
