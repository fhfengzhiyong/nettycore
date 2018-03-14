package com.straw.nettycore.tokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;

import java.io.IOException;
import java.io.Reader;

public final class MarkTokenizer  extends Tokenizer{

    //流里的数据
    protected String stringToTokenize;

    protected int position = 0;
    //用于缓存token 的文本
    protected CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);

    @Override
    public boolean incrementToken() throws IOException {
        System.out.println("---buibuibiubi");
        //清除
        clearAttributes();
        if (StringUtils.isEmpty(this.stringToTokenize)) {
            this.stringToTokenize = transformReader(input);
        }
        int nextIndex = this.stringToTokenize.indexOf('+', this.position);
        if (nextIndex != -1) {
            String nextToken = this.stringToTokenize.substring(this.position, nextIndex);
            //提取出token缓存
            this.charTermAttribute.append(nextToken);
            this.position = nextIndex + 1;
            return true;
        }else if(this.position<this.stringToTokenize.length()){
            String nextToken = this.stringToTokenize.substring(this.position);
            this.charTermAttribute.append(nextToken);
            this.position = this.stringToTokenize.length();
            return true;
        }else {
            return false;
        }
    }

    public MarkTokenizer(AttributeFactory factory) {
        super(factory);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        this.position = 0;
    }

    private String transformReader(Reader input)  {
        char[] bufferChar = new char[1024];
        StringBuilder sb = new StringBuilder();
        try {
            while (input.read(bufferChar) !=-1){
                sb.append(bufferChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.stringToTokenize = sb.toString();
        return this.stringToTokenize;
    }
}
