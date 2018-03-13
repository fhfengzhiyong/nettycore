package com.straw.nettycore.tokenizer;


import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;

import java.io.IOException;

public class BaseTools {

    public static AttributeFactory newAttributeFactory(){
        return TokenStream.DEFAULT_TOKEN_ATTRIBUTE_FACTORY;
    }

    public static String tokenstream2String(TokenStream tokenStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharTermAttribute termAtt = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.clearAttributes();
        termAtt.setEmpty().append("/>>>>>>>>>>>");
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(termAtt.toString());
            tokenStream.clearAttributes();
            termAtt.setEmpty().append("<<<<<<<<<<<<<<<");
        }
        tokenStream.close();
        return stringBuilder.toString();
    }
}
