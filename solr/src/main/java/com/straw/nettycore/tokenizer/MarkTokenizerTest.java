package com.straw.nettycore.tokenizer;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

public class MarkTokenizerTest {
    @Test
    public void test1() {
        String text = "Right+here+with+you";
        TokenStream tokenStream = new MarkTokenizer(BaseTools.newAttributeFactory());
        try {
            ((Tokenizer)tokenStream).setReader(new StringReader(text));
            String result = BaseTools.tokenstream2String(tokenStream);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
